# 싱글톤 패턴 (Singleton)
➡️ 앱 전체에서 인스턴스 딱 하나만 만들어서 계속 그거 하나만 돌려쓰는 패턴. Swift에서는 `static let`으로 구현함

## 왜 씀
- 네트워크 매니저, 로그인 세션, 설정값처럼 앱 어디서든 같은 상태 봐야하는 애들 있음
- 화면마다 새로 만들면 값 서로 어긋나거나 리소스(세션 등) 중복 생성됨
- 싱글톤 쓰면 어디서 불러도 같은 애 하나라서 상태 꼬일 일 없음

.

.

# 기본 구현
| **사용 예시**

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

- `static let shared` : 타입 프로퍼티라 인스턴스 없이 `NetworkManager.shared`로 바로 접근함
- `private init()` : 밖에서 `NetworkManager()`로 새로 못 만들게 막음. 이거 안 막으면 shared 말고 다른 인스턴스도 계속 생겨서 싱글톤 의미 없어짐
- `static let`은 처음 접근할 때 딱 한 번, 스레드 세이프하게 초기화됨 → 동시성 처리 따로 안 해줘도 됨

---

.

.

# 서비스 공부 - 이미 있는 싱글톤들
➡️ Foundation, UIKit에 원래 싱글톤으로 설계된 애들 많음

### `URLSession.shared`
```swift
let (data, response) = try await URLSession.shared.data(from: url)
```
기본 네트워크 요청용 공용 세션. 요청마다 새로 만들면 커넥션 풀 계속 새로 잡아야돼서 비효율적. 커스텀 설정 필요하면 `URLSession(configuration:)`로 따로 만들어도 됨

### `UserDefaults.standard`
```swift
UserDefaults.standard.set(true, forKey: "isLoggedIn")
let isLoggedIn = UserDefaults.standard.bool(forKey: "isLoggedIn")
```
간단 설정값 저장하는 공용 저장소. 암호화 안 되니까 토큰같은 민감값은 여기 넣으면 안 되고 Keychain 써야함

### `FileManager.default`
```swift
let exists = FileManager.default.fileExists(atPath: path)
```
파일 시스템 접근하는 공용 인스턴스

### `NotificationCenter.default`
```swift
NotificationCenter.default.post(name: .didLogin, object: nil)
```
이벤트 뿌리는 용도라 발행자, 구독자가 같은 센터 봐야 의미 있음. 그래서 default 하나 공유함

이 네 개 다 "앱 전체가 같은 상태/리소스 공유해야 함" 이거 하나로 통함

---

.

.

# 장단점
장점
- 어디서든 같은 인스턴스 접근 가능해서 상태 공유 편함
- 인스턴스 한 번만 만들어서 리소스 낭비 안 함

단점
- 전역 상태라 어디서 값 바뀌었는지 추적하기 힘듬
- 테스트할 때 진짜 싱글톤 대신 가짜(mock)로 바꿔치기 어려움 → 프로토콜로 추상화해서 주입하는 방식도 같이 고민해야함
- 여러 객체가 싱글톤 하나에 너무 의존하면 결합도 확 올라감

---

# 주의할 점
- 다 싱글톤으로 만들지 말기. 앱 전체가 진짜 공유해야하는 것만
- `private init()` 꼭 넣기
- 테스트 중요한 코드면 싱글톤보다 프로토콜 + 의존성 주입 먼저 고민하기
- 싱글톤 안에 `var` 많이 두면 여러 화면에서 동시에 값 바꿀 때 꼬일 수 있음

<details> 
<summary>정리
</summary>
싱글톤 = 인스턴스 하나만 공유하는 패턴, static let + private init()으로 구현
static let은 첫 접근 때 한 번만 스레드세이프하게 초기화됨
URLSession.shared, UserDefaults.standard, FileManager.default, NotificationCenter.default 다 실제 싱글톤 사례
전역 상태라 테스트 어려워질 수 있어서 진짜 필요한 데만 쓰기
</details>
