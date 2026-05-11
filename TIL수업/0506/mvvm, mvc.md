# MVC

→ MVC는 Model, View, Controller로 역할을 나누는 구조 패턴이다.

앱 코드를 아무렇게나 작성하면 화면 코드, 데이터 코드, 버튼 처리 코드, 서버통신 코드가 한 파일에 다 섞인다.  
MVC는 이런 문제를 줄이기 위해 역할을 세 부분으로 나눈다.

```txt
Model
→ 데이터 담당

View
→ 화면 담당

Controller
→ Model과 View 연결 담당
```

## MVC 구조

```txt
사용자
↓
View
↓
Controller
↓
Model
↓
Controller
↓
View
```

## MVC 구성 요소

| 구성 요소 | 역할 | 예시 |
|---|---|---|
| Model | 데이터와 비즈니스 로직 관리 | GanadiUser, Post, Comment |
| View | 사용자에게 보이는 화면 | Button, Text, Image |
| Controller | View와 Model 연결 | ViewController |

## Model

→ Model은 앱에서 사용하는 데이터의 형태를 정의한다.  
서버에서 받은 JSON을 Swift 구조체로 바꾸거나, 앱 내부에서 사용할 데이터 형식을 정할 때 사용한다.

```swift
struct GanadiUser {
    let name: String
    let age: Int
}
```

Model은 화면이 어떻게 생겼는지 몰라도 된다.  
즉, Model은 UI에 관심이 없고 데이터에만 관심이 있다.

## View

→ View는 사용자가 실제로 보는 화면이다.  
버튼, 텍스트, 이미지, 리스트 같은 UI 요소들이 View에 해당한다.

View는 데이터를 직접 수정하기보다는, 사용자 행동을 Controller에게 전달하는 역할을 한다.

```txt
가나디가 버튼 클릭
↓
View가 클릭 이벤트 감지
↓
Controller에게 전달
```

## Controller

→ Controller는 View와 Model 사이를 연결하는 중간 관리자다.  
사용자가 버튼을 누르면 Controller가 이벤트를 처리하고, 필요한 데이터를 Model에서 가져오거나 수정한 뒤 View를 업데이트한다.

UIKit에서는 보통 `UIViewController`가 Controller 역할을 맡는다.

## 가나디 MVC 예시

```txt
가나디가 프로필 새로고침 버튼 클릭
↓
View가 클릭 이벤트 전달
↓
Controller가 서버통신 실행
↓
Model에 사용자 데이터 저장
↓
Controller가 View에 데이터 전달
↓
View가 이름과 이미지를 화면에 표시
```

## MVC 장점과 단점

| 구분 | 내용 |
|---|---|
| 장점 | 구조가 비교적 단순하다 |
| 장점 | 처음 배울 때 이해하기 쉽다 |
| 장점 | UIKit 기반 프로젝트에서 자주 사용된다 |
| 단점 | Controller가 너무 많은 일을 맡기 쉽다 |
| 단점 | 서버통신, 화면 전환, 데이터 처리까지 Controller에 몰릴 수 있다 |
| 단점 | 프로젝트가 커지면 Massive ViewController 문제가 생길 수 있다 |

## Massive ViewController

→ MVC에서 가장 많이 생기는 문제다.  
Controller가 View와 Model 사이를 연결하는 역할만 하면 괜찮지만, 실제 개발에서는 Controller가 너무 많은 일을 하게 된다.

예시:

```txt
Controller가 하는 일
- 버튼 클릭 처리
- 화면 전환
- 서버통신
- JSON 디코딩
- 에러 처리
- 데이터 가공
- UI 업데이트
```

이렇게 되면 Controller 파일 하나가 너무 커지고 유지보수가 어려워진다.  
그래서 Service, MVVM 같은 구조를 사용해서 역할을 더 나누기도 한다.

## MVC 한줄 정리

```txt
MVC
→ Model, View, Controller로 나누지만 Controller가 커지기 쉬운 구조
```

---

# MVVM

→ MVVM은 Model, View, ViewModel로 역할을 나누는 구조 패턴이다.

MVC에서 Controller가 너무 많은 일을 맡는 문제가 생기자, 화면에 필요한 데이터 가공과 상태 관리를 ViewModel로 분리한 방식이다.

```txt
Model
→ 데이터 담당

View
→ 화면 표시 담당

ViewModel
→ 화면에 필요한 데이터 가공과 상태 관리 담당
```

## MVVM 구조

```txt
View
↕
ViewModel
↕
Model
```

View는 화면을 보여주고, ViewModel은 화면에 필요한 상태와 로직을 관리한다.  
Model은 실제 데이터의 형태를 담당한다.

## MVVM 구성 요소

| 구성 요소 | 역할 | 예시 |
|---|---|---|
| Model | 실제 데이터 구조 | GanadiUser, GanadiPost |
| View | 화면 표시 | SwiftUI View |
| ViewModel | 상태 관리, 데이터 가공 | GanadiViewModel |

## Model

→ Model은 서버나 DB에서 받은 데이터의 구조를 나타낸다.

```swift
struct GanadiPost: Codable {
    let id: Int
    let title: String
    let isLiked: Bool
}
```

Model은 데이터를 표현하는 역할만 하고, 화면을 어떻게 보여줄지는 신경 쓰지 않는다.

## View

→ View는 사용자에게 보이는 화면이다.  
SwiftUI에서는 `struct ContentView: View` 같은 코드가 View에 해당한다.

View는 최대한 화면을 그리는 일에 집중하는 것이 좋다.

```swift
struct GanadiPostView: View {
    
    @StateObject var viewModel = GanadiPostViewModel()
    
    var body: some View {
        VStack {
            Text(viewModel.title)
            
            Button("좋아요") {
                viewModel.tapLike()
            }
        }
    }
}
```

## ViewModel

→ ViewModel은 View에 보여줄 데이터를 준비하고, 사용자의 행동을 처리하는 역할을 한다.

ViewModel이 하는 일:

- 서버에서 데이터 요청
- Model 데이터를 View에 맞게 가공
- 좋아요 상태 관리
- 로딩 상태 관리
- 에러 상태 관리
- View가 사용할 값 제공

```swift
final class GanadiPostViewModel: ObservableObject {
    
    @Published var title: String = ""
    @Published var isLiked: Bool = false
    
    func fetchPost() {
        title = "가나디의 하루"
        isLiked = false
    }
    
    func tapLike() {
        isLiked.toggle()
    }
}
```

## MVVM에서 데이터 흐름

```txt
View
↓
사용자 행동 전달
↓
ViewModel
↓
Service 호출
↓
Model 생성
↓
ViewModel이 화면용 데이터로 가공
↓
View 업데이트
```

## 가나디 MVVM 예시

```txt
가나디 게시글 화면 진입
↓
View가 ViewModel의 fetchPost() 호출
↓
ViewModel이 Service에게 서버통신 요청
↓
Service가 서버에서 JSON 응답 받음
↓
Model로 디코딩
↓
ViewModel이 title, isLiked 값으로 가공
↓
View가 자동으로 업데이트
```

## SwiftUI에서 MVVM이 잘 맞는 이유

→ SwiftUI는 상태가 바뀌면 화면이 다시 그려지는 방식이다.  
그래서 ViewModel의 `@Published` 값이 바뀌면 View가 자동으로 바뀐다.

```swift
final class GanadiViewModel: ObservableObject {
    @Published var name = "가나디"
}
```

```swift
struct GanadiView: View {
    
    @StateObject var vm = GanadiViewModel()
    
    var body: some View {
        Text(vm.name)
    }
}
```

## MVVM 장점과 단점

| 구분 | 내용 |
|---|---|
| 장점 | View와 로직을 분리할 수 있다 |
| 장점 | SwiftUI의 상태 관리 방식과 잘 어울린다 |
| 장점 | ViewModel만 따로 테스트하기 좋다 |
| 장점 | View 코드가 비교적 깔끔해진다 |
| 단점 | 처음에는 구조가 어렵게 느껴질 수 있다 |
| 단점 | 파일 수가 많아진다 |
| 단점 | ViewModel이 너무 커지면 Massive ViewModel 문제가 생길 수 있다 |

## MVC와 MVVM 비교

| 항목 | MVC | MVVM |
|---|---|---|
| 구성 | Model, View, Controller | Model, View, ViewModel |
| 중심 역할 | Controller | ViewModel |
| 데이터 가공 위치 | Controller에 몰리기 쉬움 | ViewModel에서 처리 |
| View 역할 | 화면 표시 | 화면 표시 |
| SwiftUI 적합성 | 비교적 낮음 | 높음 |
| UIKit 적합성 | 높음 | 사용 가능 |
| 문제점 | Massive ViewController | Massive ViewModel |
| 유지보수 | 규모 커지면 어려움 | 역할 분리로 비교적 쉬움 |

## MVVM 한줄 정리

```txt
MVVM
→ View는 화면만, ViewModel은 상태와 로직을 맡아서 SwiftUI와 잘 맞는 구조
```

---

# 서버통신

→ 서버통신은 앱과 서버가 데이터를 주고받는 과정이다.

앱 혼자 모든 데이터를 가지고 있으면 로그인, 채팅, 게시글, 랭킹, 게임 기록 같은 기능을 제대로 만들기 어렵다.  
그래서 앱은 서버에게 필요한 데이터를 요청하고, 서버는 그 결과를 응답으로 보내준다.

```txt
Client
→ 요청 Request

Server
→ 응답 Response
```

## 서버통신 기본 흐름

```txt
앱에서 요청 생성
↓
URL 설정
↓
HTTP Method 설정
↓
필요하면 Body 추가
↓
서버에 요청 전송
↓
서버 응답 수신
↓
JSON 디코딩
↓
Swift Model로 변환
↓
화면에 표시
```

## Request와 Response

| 용어 | 의미 | 예시 |
|---|---|---|
| Request | 클라이언트가 서버에게 보내는 요청 | 로그인 요청 |
| Response | 서버가 클라이언트에게 보내는 응답 | 로그인 성공 여부 |
| Client | 서버에게 요청하는 쪽 | iPhone 앱 |
| Server | 요청을 받고 처리하는 쪽 | 백엔드 서버 |
| API | 서버와 약속된 통신 주소 | /api/game/play |

## HTTP Method

| Method | 의미 | 사용 예시 |
|---|---|---|
| GET | 데이터를 가져옴 | 게시글 목록 불러오기 |
| POST | 데이터를 새로 보냄 | 로그인, 회원가입, 게임 시작 |
| PUT | 데이터를 전체 수정 | 프로필 전체 수정 |
| PATCH | 데이터를 일부 수정 | 닉네임만 수정 |
| DELETE | 데이터를 삭제 | 게시글 삭제 |

## JSON

→ JSON은 서버와 앱이 데이터를 주고받을 때 많이 사용하는 형식이다.

```json
{
  "name": "가나디",
  "level": 3,
  "isLiked": true
}
```

Swift에서 사용하려면 JSON을 바로 쓰는 것이 아니라, Swift 구조체로 바꾸는 과정이 필요하다.  
이 과정을 디코딩이라고 한다.

## Decoding

→ Decoding은 서버가 보내준 JSON 데이터를 Swift가 이해할 수 있는 구조체로 바꾸는 과정이다.

```swift
struct GanadiUser: Codable {
    let name: String
    let level: Int
    let isLiked: Bool
}
```

```swift
let user = try JSONDecoder().decode(GanadiUser.self, from: data)
```

## DTO와 Domain Model

→ 서버에서 받은 데이터 모양과 앱 내부에서 쓰는 데이터 모양이 항상 같지는 않다.  
그래서 서버 응답을 그대로 받는 모델과 앱 내부에서 쓰는 모델을 나누기도 한다.

| 구분 | 의미 | 예시 |
|---|---|---|
| DTO | 서버 응답을 그대로 받는 데이터 전송용 모델 | GanadiUserDTO |
| Domain Model | 앱 내부에서 실제로 쓰는 모델 | GanadiUser |
| Mapping | DTO를 Domain Model로 바꾸는 과정 | dto.toDomain() |

## DTO 예시

```swift
struct GanadiUserDTO: Codable {
    let user_name: String
    let user_level: Int
}
```

## Domain Model 예시

```swift
struct GanadiUser {
    let name: String
    let level: Int
}
```

## Mapping 예시

```swift
extension GanadiUserDTO {
    
    func toDomain() -> GanadiUser {
        return GanadiUser(
            name: user_name,
            level: user_level
        )
    }
}
```

## 서버통신 Swift 예시

```swift
import Foundation

struct GanadiGameResponse: Codable {
    let message: String
    let success: Bool
}

final class GanadiGameService {
    
    func playGame(completion: @escaping (GanadiGameResponse?) -> Void) {
        guard let url = URL(string: "http://ssh.gsmsv.site:22119/api/game/play") else {
            completion(nil)
            return
        }
        
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        
        URLSession.shared.dataTask(with: request) { data, response, error in
            guard let data = data else {
                completion(nil)
                return
            }
            
            let result = try? JSONDecoder().decode(GanadiGameResponse.self, from: data)
            completion(result)
        }.resume()
    }
}
```

## 상태 코드

| 상태 코드 | 의미 |
|---|---|
| 200 | 성공 |
| 201 | 생성 성공 |
| 400 | 요청 형식 오류 |
| 401 | 인증 필요 |
| 403 | 권한 없음 |
| 404 | 주소 없음 |
| 405 | 요청 Method가 맞지 않음 |
| 500 | 서버 내부 오류 |

## 서버통신 한줄 정리

```txt
서버통신
→ 앱이 서버에게 요청하고, 서버가 응답한 데이터를 Swift에서 사용할 수 있게 변환하는 과정
```

---

# 전체 정리

| 개념 | 핵심 |
|---|---|
| Service | 서버통신과 기능 처리를 View 밖으로 분리하는 계층 |
| 낙천적 프로그래밍 | 서버 응답 전에 UI를 먼저 바꾸고 실패하면 복구하는 방식 |
| MVC | Controller가 View와 Model 사이를 연결하는 구조 |
| MVVM | ViewModel이 View 상태와 로직을 관리하는 구조 |
| 서버통신 | 앱과 서버가 Request와 Response로 데이터를 주고받는 과정 |