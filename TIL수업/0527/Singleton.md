# Singleton

## Singleton이란?

Singleton은 앱 전체에서 하나의 객체만 생성하고 공유해서 사용하는 디자인 패턴

보통 여러 화면에서 같은 데이터를 사용하거나 공통 기능을 관리할 때 사용

예를 들어

- 로그인 정보 관리
- 사용자 정보 관리
- 네트워크 통신
- 캐시 관리
- 앱 설정 관리

등이 있음

---

## 왜 사용할까?

일반 객체는 생성할 때마다 새로운 인스턴스가 만들어짐

swift let userManager1 = UserManager() let userManager2 = UserManager() 

위 코드는 서로 다른 객체

따라서 데이터도 따로 관리됨

swift userManager1.nickname = "민준"  print(userManager2.nickname) 

원하는 값을 가져올 수 없음

Singleton을 사용하면 앱 전체에서 같은 객체를 사용하기 때문에 데이터가 공유됨

---

## 기본 구조

swift final class UserManager {      static let shared = UserManager()      private init() { } } 

---

## 코드 분석

### static let shared

swift static let shared = UserManager() 

앱이 실행되는 동안 하나의 객체만 생성

어디서든 같은 객체에 접근 가능

---

### private init()

swift private init() { } 

외부에서 객체 생성을 막음

만약 private를 제거하면

swift let manager = UserManager() 

처럼 새로운 객체를 계속 만들 수 있음

---

## 사용 방법

swift UserManager.shared 

객체를 직접 생성하지 않고 shared를 통해 접근

---

## 데이터 공유 예제

swift final class UserManager {      static let shared = UserManager()      private init() { }      var nickname = "" } 

Home 화면

swift UserManager.shared.nickname = "민준" 

Profile 화면

swift print(UserManager.shared.nickname) 

출력

swift 민준 

같은 객체를 사용하기 때문에 데이터가 유지됨

---

## 실무 예제

### NetworkManager

swift final class NetworkManager {      static let shared = NetworkManager()      private init() { }      func request() {         print("API 요청")     } } 

사용

swift NetworkManager.shared.request() 

---

### UserDefaults

swift UserDefaults.standard 

앱 데이터를 저장하고 불러올 때 사용

---

### URLSession

swift URLSession.shared 

네트워크 통신에 사용

---

### NotificationCenter

swift NotificationCenter.default 

화면 간 이벤트 전달에 사용

---

### FileManager

swift FileManager.default 

파일 저장 및 관리에 사용

---

## Singleton 구조

text App  ├─ HomeViewController  ├─ ProfileViewController  ├─ SettingViewController  │  └─ UserManager.shared 

모든 화면이 같은 객체를 공유

---

## 장점

| 장점 | 설명 |
|--------|--------|
| 데이터 공유 | 여러 화면에서 같은 데이터 사용 |
| 메모리 절약 | 객체를 한 번만 생성 |
| 접근 편리 | 어디서든 접근 가능 |
| 관리 용이 | 공통 기능을 한 곳에서 관리 |

---

## 단점

| 단점 | 설명 |
|--------|--------|
| 의존성 증가 | 특정 객체에 의존하게 됨 |
| 테스트 어려움 | Mock 객체 사용이 어려움 |
| 전역 상태 문제 | 예상치 못한 값 변경 가능 |
| 유지보수 어려움 | 남발하면 구조가 복잡해짐 |

---

## Singleton을 사용하는 경우

사용하는 경우

- NetworkManager
- UserManager
- AuthManager
- CacheManager
- AnalyticsManager

사용하지 않는 경우

- ViewController
- UITableViewCell
- UICollectionViewCell

화면이나 셀은 Singleton으로 만들지 않음

---

## Singleton vs 일반 객체

| 구분 | Singleton | 일반 객체 |
|--------|--------|--------|
| 생성 횟수 | 1번 | 여러 번 |
| 데이터 공유 | 가능 | 불가능 |
| 접근 방법 | shared 사용 | 직접 생성 |
| 메모리 사용 | 적음 | 많아질 수 있음 |
| 사용 목적 | 공통 기능 관리 | 개별 기능 처리 |

---

# 정리

- Singleton은 앱 전체에서 하나의 객체만 사용하는 디자인 패턴
- static let shared로 공용 객체 생성
- private init()으로 외부 생성 방지
- 여러 화면에서 같은 데이터를 공유할 수 있음
- URLSession, UserDefaults, NotificationCenter 등이 Singleton 패턴을 사용
- 편리하지만 남용하면 의존성이 높아질 수 있으므로 공통 기능에만 사용하는 것이 좋음