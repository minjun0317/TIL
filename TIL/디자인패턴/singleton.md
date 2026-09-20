# 싱글톤 패턴 (Singleton Pattern)

앱이 실행되는 동안 어떤 타입의 인스턴스를 딱 하나만 만들어서, 그 하나를 여러 곳에서 공유해서 쓰는 디자인 패턴이다. Swift에서는 보통 `static let`으로 구현한다.

## 왜 필요할까?

네트워크 매니저, 로그인 세션, 앱 설정값처럼 앱 전체에서 **같은 상태를 공유해야 하는 대상**이 있다. 이런 걸 화면마다 새로 만들면 값이 서로 어긋나거나, 리소스(네트워크 세션 등)가 불필요하게 여러 번 생성될 수 있다.

싱글톤을 쓰면 어디서든 같은 인스턴스에 접근하니까 상태가 하나로 유지되고, 리소스 생성 비용도 한 번으로 끝난다.

## 기본 구현

```swift
class NetworkManager {
    static let shared = NetworkManager()

    private init() {}

    func fetchData() {
        print("데이터 요청")
    }
}

NetworkManager.shared.fetchData()
```

- `static let shared`: 타입 프로퍼티라서 인스턴스 없이 `NetworkManager.shared`로 바로 접근 가능. `let`이라 한 번 만들어지면 바뀌지 않는다.
- `private init()`: 외부에서 `NetworkManager()`로 새로 만들지 못하게 막는다. 이게 없으면 `shared` 말고도 다른 인스턴스가 계속 생길 수 있어서 싱글톤 의미가 없어진다.
- Swift의 `static let`은 처음 접근하는 시점에 딱 한 번, 스레드 안전하게 초기화되는 게 언어 차원에서 보장된다. 그래서 싱글톤 구현에 `static let`을 쓰면 별도로 동시성 처리를 해줄 필요가 없다.

---

## 서비스 공부 - Swift/iOS가 이미 제공하는 싱글톤들

Foundation, UIKit에는 이미 싱글톤으로 설계된 타입이 많다. 직접 만들기 전에 이런 것들을 먼저 살펴보면 왜 싱글톤이 필요한지 감이 온다.

### `URLSession.shared`

```swift
let (data, response) = try await URLSession.shared.data(from: url)
```

기본 설정으로 네트워크 요청을 보낼 때 쓰는 공용 세션. 요청마다 `URLSession`을 새로 만들면 커넥션 풀 같은 리소스를 매번 새로 잡아야 해서 비효율적이다. 커스텀 설정(캐시 정책, 타임아웃 등)이 필요할 땐 직접 `URLSession(configuration:)`으로 만들어 써도 된다.

### `UserDefaults.standard`

```swift
UserDefaults.standard.set(true, forKey: "isLoggedIn")
let isLoggedIn = UserDefaults.standard.bool(forKey: "isLoggedIn")
```

앱의 간단한 설정값을 저장하는 공용 저장소. 앱 어디서든 같은 저장소를 봐야 하니까 싱글톤 구조가 맞다. 다만 암호화되지 않으므로 토큰처럼 민감한 값은 넣으면 안 되고, 그런 값은 Keychain에 저장해야 한다.

### `FileManager.default`

```swift
let exists = FileManager.default.fileExists(atPath: path)
```

파일 시스템 접근을 담당하는 공용 인스턴스. 필요하면 `FileManager()`로 별도 인스턴스를 만들 수도 있지만, 대부분은 `default`로 충분하다.

### `NotificationCenter.default`

```swift
NotificationCenter.default.post(name: .didLogin, object: nil)
```

앱 전역에서 이벤트를 브로드캐스트하는 용도라서, 발행자와 구독자가 같은 센터를 봐야 의미가 있다. 그래서 기본적으로 하나의 공용 인스턴스(`default`)를 공유한다.

이 네 가지 모두 "앱 전체가 같은 상태/리소스를 공유해야 한다"는 공통점이 있고, 그게 싱글톤을 쓰는 이유와 그대로 연결된다.

---

## 장단점

**장점**
- 어디서든 동일한 인스턴스에 접근할 수 있어 상태 공유가 쉽다.
- 인스턴스를 한 번만 만들기 때문에 리소스 낭비를 줄인다.

**단점**
- 전역 상태이기 때문에 어디서 값이 바뀌었는지 추적하기 어려워진다.
- 테스트할 때 실제 싱글톤 대신 가짜(mock) 객체로 바꿔 끼우기 어렵다. 테스트 코드를 짜려면 보통 프로토콜로 추상화해서 의존성을 주입하는 방식을 같이 고려해야 한다.
- 여러 객체가 싱글톤 하나에 강하게 의존하게 되면 모듈 간 결합도가 높아진다.

## 사용 시 주의사항

1. 모든 걸 싱글톤으로 만들지 않는다. 앱 전체가 공유해야 하는 상태/리소스일 때만 쓴다.
2. `private init()`을 꼭 넣어서 추가 인스턴스 생성을 막는다.
3. 테스트 가능성이 중요한 코드라면, 싱글톤 자체보다 프로토콜 + 의존성 주입 구조를 우선 고려한다.
4. 싱글톤 안에 가변 상태(`var`)를 많이 두면 여러 화면에서 동시에 값을 바꿀 때 꼬일 수 있으니, 꼭 필요한 상태만 최소한으로 둔다.

## 핵심 정리

- 싱글톤은 앱 전체에서 인스턴스를 하나만 공유하는 패턴이고, Swift에서는 `static let` + `private init()`으로 구현한다.
- `static let`은 첫 접근 시 한 번만, 스레드 안전하게 초기화되므로 동시성 처리를 따로 안 해도 된다.
- `URLSession.shared`, `UserDefaults.standard`, `FileManager.default`, `NotificationCenter.default`가 대표적인 실제 싱글톤 사례다.
- 전역 상태라 테스트가 어려워질 수 있으니, 꼭 공유해야 하는 대상에만 제한적으로 사용한다.

## 참고

- [Apple - URLSession](https://developer.apple.com/documentation/foundation/urlsession)
- [Apple - UserDefaults](https://developer.apple.com/documentation/foundation/userdefaults)
- [Apple - FileManager](https://developer.apple.com/documentation/foundation/filemanager)
- [Apple - NotificationCenter](https://developer.apple.com/documentation/foundation/notificationcenter)
