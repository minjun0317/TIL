# Social login 구현하기

Apple 로그인은 Apple Account를 이용해 가입·로그인할 수 있게 하는 인증 기능이다. SwiftUI에서는 `SignInWithAppleButton`으로 인증 요청을 시작하고, 성공 결과로 전달받은 자격 증명을 서버에서 검증해 서비스 세션을 발급한다.

참고 글의 UIKit `ASAuthorizationController` 방식과 달리, 이 문서에서는 SwiftUI의 `SignInWithAppleButton`을 기준으로 구현한다. 두 방식 모두 최종적으로는 `ASAuthorizationAppleIDCredential`을 통해 같은 사용자 정보를 받는다.

## 왜 Apple 로그인이 필요할까?

Google, Kakao, Naver처럼 외부 소셜 로그인을 앱의 메인 로그인 방식으로 제공하면, App Store 심사 가이드라인 4.8 때문에 Apple 로그인도 같이 제공해야 하는 경우가 있다.

Apple 로그인의 장점은 사용자가 새 비밀번호를 만들 필요가 없고, Face ID / Touch ID로 바로 인증할 수 있다는 점이다. 또 이메일을 공개하지 않고 `Hide My Email`을 선택하면, 실제 메일 주소 대신 Apple이 만들어 준 릴레이 이메일을 받을 수 있다.

여기서 중요한 점은 **이메일이 회원을 구분하는 기준이 아니라는 것**이다. Apple 로그인 회원은 Apple이 주는 `user` 값을 기준으로 관리해야 한다.

## 인증 흐름

```text
1. 사용자가 Apple 로그인 버튼을 누른다.
2. 앱이 Apple에 "이름과 이메일을 받을게요"라고 요청한다.
3. 사용자가 Face ID / Touch ID로 인증한다.
4. Apple이 user, email, identityToken, authorizationCode를 앱에 준다.
5. 앱은 이 값을 서버에 보낸다.
6. 서버는 Apple 토큰을 검증한 뒤, 우리 서비스의 access token을 발급한다.
7. 앱은 access token을 Keychain에 저장하고 메인 화면으로 이동한다.
```

4번은 Apple 인증 성공이고, 6번까지 완료되어야 서비스 로그인도 성공한 상태가 된다. Apple 인증과 서비스 세션 발급은 분리해서 처리해야 한다.

## 1. Xcode 설정하기

코드보다 먼저 Capability를 추가해야 한다.

1. Xcode에서 프로젝트 파일을 선택한다.
2. 앱 Target → `Signing & Capabilities`로 들어간다.
3. `+ Capability` 버튼을 누른다.
4. `Sign in with Apple`을 추가한다.

이 설정은 앱에 Sign in with Apple entitlement를 추가하는 과정이다. 버튼 코드만 작성하고 Capability를 누락하면 인증 요청이 정상 동작하지 않는다.

```swift
import SwiftUI
import AuthenticationServices
```

`AuthenticationServices` 안에 Apple 로그인에 필요한 버튼, 요청 객체, 인증 결과 객체가 들어 있다.

## 2. 로그인 버튼 구현

SwiftUI에서는 Apple이 제공하는 `SignInWithAppleButton`을 사용할 수 있다.

```swift
struct LoginView: View {
    var body: some View {
        SignInWithAppleButton(
            .signIn,
            onRequest: { request in
                request.requestedScopes = [.fullName, .email]
            },
            onCompletion: { result in
                switch result {
                case .success(let authorization):
                    print("Apple 로그인 성공")
                case .failure(let error):
                    print("Apple 로그인 실패: \(error.localizedDescription)")
                }
            }
        )
        .signInWithAppleButtonStyle(.black)
        .frame(height: 50)
        .padding(.horizontal)
    }
}
```

- `.signIn`: 버튼 문구를 정한다. 가입 화면이면 `.signUp`, 계속 진행하는 화면이면 `.continue`도 사용할 수 있다.
- `onRequest`: Apple 인증 화면이 뜨기 전에, 어떤 정보를 요청할지 설정한다.
- `onCompletion`: 인증 화면이 닫힌 뒤 성공/실패 결과를 받는다.
- `.signInWithAppleButtonStyle(.black)`: 버튼 색상을 정한다. `.white`, `.whiteOutline`도 있다.

커스텀 버튼을 구현할 수도 있지만 Apple 로그인 버튼에는 디자인 가이드가 있다. 기본 제공 버튼을 사용하면 가이드라인을 준수하기 쉽다.

## 3. `requestedScopes`는 왜 설정할까?

```swift
request.requestedScopes = [.fullName, .email]
```

`requestedScopes`는 Apple에게 "사용자의 이름과 이메일을 앱에서 쓰고 싶다"고 요청하는 부분이다.

- `.fullName`: 이름 요청
- `.email`: 이메일 요청

요청한다고 무조건 실제 이메일을 받는 것은 아니다. 사용자는 실제 이메일을 공유할 수도 있고, Apple 릴레이 이메일을 선택할 수도 있다.

> `fullName`과 `email`은 최초 로그인에서만 전달될 수 있다.

두 번째 로그인부터 `email`이 `nil`이라고 해서 구현이 잘못된 것이 아니다. Apple은 이미 한 번 공유한 개인정보를 매번 다시 보내지 않는다. 그래서 첫 로그인에 받은 이름과 이메일은 바로 서버에 저장해야 한다.

## 4. 인증 성공 결과 처리

인증 성공 결과 안에는 `credential`이 들어 있다. Apple 로그인으로 받은 값인지 확인한 후 꺼내야 한다.

```swift
private func handleAuthorization(_ authorization: ASAuthorization) {
    guard let credential = authorization.credential as? ASAuthorizationAppleIDCredential else {
        return
    }

    let userID = credential.user
    let email = credential.email
    let fullName = credential.fullName

    let identityToken = credential.identityToken.flatMap {
        String(data: $0, encoding: .utf8)
    }

    let authorizationCode = credential.authorizationCode.flatMap {
        String(data: $0, encoding: .utf8)
    }

    print("userID: \(userID)")
    print("email: \(email ?? "없음")")
    print("name: \(fullName?.givenName ?? "") \(fullName?.familyName ?? "")")
}
```

### `ASAuthorizationAppleIDCredential`로 형 변환

`authorization.credential`은 공통 타입이라서, Apple ID 로그인에 대한 `ASAuthorizationAppleIDCredential`로 형 변환해야 한다. 변환이 성공하면 아래에서 Apple 로그인 전용 프로퍼티를 사용할 수 있다.

### `credential.user`

Apple이 앱 개발자 팀 기준으로 발급하는 고유 사용자 식별자다.

```swift
let userID = credential.user
```

우리 DB에서는 이 값을 `appleUserID` 같은 컬럼에 저장해 Apple 회원을 찾는 키로 사용한다. 이메일은 사용자가 비공개 이메일을 선택할 수 있고, 기존 계정의 이메일과 다를 수 있으므로 회원 식별자로 쓰면 안 된다.

### `credential.fullName`, `credential.email`

```swift
let email = credential.email
let fullName = credential.fullName
```

이름과 이메일은 `Optional`이다. 첫 로그인에서만 값이 오고 다음 로그인부터는 `nil`일 수 있기 때문이다.

그래서 회원 생성 API를 만들 때도 `email`을 무조건 required로 가정하면 안 된다. 이미 가입된 사용자는 `userID`로 조회한 뒤, 저장해 둔 이름과 이메일을 사용하면 된다.

### `identityToken`, `authorizationCode` 변환

```swift
let identityToken = credential.identityToken.flatMap {
    String(data: $0, encoding: .utf8)
}
```

Apple은 토큰을 `Data`로 준다. 서버에 JSON으로 보내려면 문자열로 바꿔야 하므로 `String(data:encoding:)`을 사용한다.

- `identityToken`: 사용자의 식별 정보가 들어 있는 JWT
- `authorizationCode`: Apple 서버와 토큰을 교환할 때 쓰는 짧은 수명의 1회성 코드

토큰 내용을 앱에서 디코딩해 보는 것과, 토큰의 서명 및 claim을 서버에서 검증하는 것은 다른 작업이다. 클라이언트에서 토큰을 디코딩한 결과만으로 로그인 성공을 결정하면 안 된다.

토큰 값은 로그에 남기지 않는다. 디버깅을 위해 `print`했다가 로그 수집 도구에 인증 정보가 남을 수 있다.

## 5. 성공 결과를 하나의 타입으로 묶기

서버에 보낼 값을 각각 전달하면 코드가 지저분해질 수 있어서, 아래처럼 payload로 묶어 두면 편하다.

```swift
struct AppleLoginRequest: Encodable {
    let userID: String
    let email: String?
    let givenName: String?
    let familyName: String?
    let identityToken: String
    let authorizationCode: String
}
```

그리고 성공 처리 코드를 아래처럼 바꿀 수 있다.

```swift
guard
    let credential = authorization.credential as? ASAuthorizationAppleIDCredential,
    let tokenData = credential.identityToken,
    let identityToken = String(data: tokenData, encoding: .utf8),
    let codeData = credential.authorizationCode,
    let authorizationCode = String(data: codeData, encoding: .utf8)
else {
    return
}

let request = AppleLoginRequest(
    userID: credential.user,
    email: credential.email,
    givenName: credential.fullName?.givenName,
    familyName: credential.fullName?.familyName,
    identityToken: identityToken,
    authorizationCode: authorizationCode
)
```

`guard`를 한 번에 사용한 이유는 서버 통신 전에 필요한 값이 하나라도 없으면 더 진행하면 안 되기 때문이다. 특히 `identityToken`, `authorizationCode`가 없는 상태에서 가입 API를 호출하면 서버도 사용자를 검증할 방법이 없다.

## 6. 서버에는 무엇을 보내야 할까?

앱은 Apple 인증을 직접 신뢰하지 않고, 필요한 정보를 서버에 전달한다.

```swift
func signInWithApple(_ request: AppleLoginRequest) async throws -> Session {
    var urlRequest = URLRequest(url: URL(string: "https://api.example.com/auth/apple")!)
    urlRequest.httpMethod = "POST"
    urlRequest.setValue("application/json", forHTTPHeaderField: "Content-Type")
    urlRequest.httpBody = try JSONEncoder().encode(request)

    let (data, response) = try await URLSession.shared.data(for: urlRequest)

    guard let httpResponse = response as? HTTPURLResponse,
          200..<300 ~= httpResponse.statusCode else {
        throw URLError(.badServerResponse)
    }

    return try JSONDecoder().decode(Session.self, from: data)
}

struct Session: Decodable {
    let accessToken: String
    let refreshToken: String
}
```

위 코드는 앱 → 서버 통신 예시다. URL은 프로젝트의 실제 API 주소로 바꿔야 한다.

서버는 받은 `identityToken`을 Apple 공개 키로 검증해야 한다. 검증 항목은 아래와 같다.

```text
iss   : https://appleid.apple.com 인지
aud   : 우리 앱의 Bundle ID(client_id)와 같은지
exp   : 만료되지 않았는지
서명  : Apple 공개 키로 검증되는지
```

그리고 `authorizationCode`를 Apple 서버에 전달해 토큰을 교환한다. 여기서 필요한 Apple private key와 `client_secret`은 절대로 iOS 앱에 넣으면 안 되고 서버에만 있어야 한다.

정리하면, 앱은 Apple에서 받은 값을 전달하는 역할이고, **진짜 검증과 회원 생성은 서버 역할**이다.

## 7. 로그인 성공 후 무엇을 저장할까?

서버 검증이 끝나면 서버는 우리 서비스의 `accessToken`, `refreshToken`을 준다.

```swift
do {
    let session = try await signInWithApple(request)

    try KeychainService.save(session.accessToken, for: "accessToken")
    try KeychainService.save(session.refreshToken, for: "refreshToken")
    UserDefaults.standard.set(request.userID, forKey: "appleUserID")
} catch {
    print("서버 로그인 실패")
}
```

저장 위치는 정보의 민감도에 따라 구분한다.

- `accessToken`, `refreshToken`: 민감한 인증 정보이므로 **Keychain**에 저장
- `appleUserID`: 다음 실행 시 Apple 자격 증명 상태를 확인하기 위한 식별자이므로 `UserDefaults`에 저장 가능

`UserDefaults`는 편하지만 암호화된 보안 저장소가 아니다. 서비스 토큰까지 넣는 것은 피해야 한다.

## 8. 자동 로그인은 어떻게 확인할까?

사용자가 Apple 설정에서 앱 연결을 해제했을 수도 있다. 앱을 다시 열었을 때 저장된 `appleUserID`로 자격 증명 상태를 확인한다.

```swift
func checkAppleLoginState() {
    guard let userID = UserDefaults.standard.string(forKey: "appleUserID") else {
        return
    }

    let provider = ASAuthorizationAppleIDProvider()

    provider.getCredentialState(forUserID: userID) { state, error in
        DispatchQueue.main.async {
            switch state {
            case .authorized:
                print("Apple 로그인 연동 상태")

            case .revoked, .notFound:
                print("Apple 로그인이 해제되었거나 계정을 찾을 수 없음")
                logout()

            default:
                break
            }
        }
    }
}
```

- `.authorized`: Apple 계정 연동 상태가 정상이다.
- `.revoked`: 사용자가 Apple 설정에서 앱 연결을 해제했을 수 있다.
- `.notFound`: 저장한 사용자 ID에 해당하는 연결 정보를 찾지 못했다.

`.authorized`가 나왔다고 우리 서비스의 access token까지 유효하다는 뜻은 아니다. Apple 로그인 상태와 우리 서버 토큰의 만료 여부를 둘 다 확인해야 한다.

## 9. 구현 시 주의사항

1. Apple 로그인 버튼 성공 = 우리 서비스 로그인 성공이 아니다.
2. `user`로 회원을 찾고, 이메일로 회원을 찾지 않는다.
3. 이름과 이메일은 최초 로그인에서만 올 수 있으니 바로 저장한다.
4. `identityToken`은 앱에서 읽어 보는 것이 아니라 서버에서 서명까지 검증한다.
5. access token과 refresh token은 Keychain에 저장한다.
6. Apple 연결이 해제되면 저장한 서비스 토큰도 지우고 다시 로그인하게 한다.

## 핵심 정리

- `SignInWithAppleButton`은 Apple 인증을 시작하는 UI이며, 로그인 완료 처리는 `onCompletion`에서 수행한다.
- `credential.user`는 Apple 로그인 사용자를 식별하는 기준 값이다.
- `fullName`, `email`은 최초 동의 시에만 전달될 수 있으므로 즉시 저장한다.
- `identityToken`은 JWT이고, `authorizationCode`는 서버 토큰 교환에 사용하는 1회성 코드다.
- 서버는 토큰 서명과 `iss`, `aud`, `exp`를 검증한 후 서비스 세션을 발급한다.
- 서비스 토큰은 Keychain에, Apple 사용자 식별자는 자격 증명 상태 확인을 위해 저장한다.

## 참고

- [Apple 로그인 구현 방법](https://ios-daniel-yang.tistory.com/entry/iOSSwift-Apple-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B5%AC%ED%98%84-%EB%B0%A9%EB%B2%95)
- [Apple - SignInWithAppleButton](https://developer.apple.com/documentation/authenticationservices/signinwithapplebutton)
- [Apple - Authenticating users with Sign in with Apple](https://developer.apple.com/documentation/signinwithapple/authenticating-users-with-sign-in-with-apple)
- [Apple - Verifying a user](https://developer.apple.com/documentation/signinwithapple/verifying-a-user)
