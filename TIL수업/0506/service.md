# Service

→ Service는 앱에서 특정 기능을 실제로 처리하는 계층이다.  
특히 서버통신, 데이터 요청, JSON 디코딩, API 호출처럼 View가 직접 들고 있으면 복잡해지는 로직을 따로 분리할 때 사용한다.

쉽게 말하면 Service는 화면이 직접 서버에 가는 것이 아니라, 화면 대신 서버에 다녀오는 역할이다.

```txt
View
↓
Service
↓
Server / API
↓
Service
↓
View
```

## Service가 필요한 이유

→ 앱이 작을 때는 View 안에 서버통신 코드를 바로 적어도 작동은 한다.  
하지만 기능이 많아지면 View가 화면을 그리는 역할뿐만 아니라 서버통신, 데이터 처리, 에러 처리까지 전부 맡게 된다.

이러면 View 코드가 너무 길어지고, 나중에 수정할 때 어디를 고쳐야 하는지 찾기 어려워진다.

그래서 서버통신 같은 기능을 Service로 분리한다.

## Service의 핵심 역할

| 역할 | 설명 |
|---|---|
| 서버통신 담당 | API 주소로 요청을 보내고 응답을 받음 |
| 데이터 변환 | 서버에서 받은 JSON을 Swift 모델로 변환 |
| 기능 재사용 | 여러 화면에서 같은 통신 코드를 다시 사용할 수 있음 |
| View 분리 | View는 화면 표시만 집중할 수 있음 |
| 유지보수 | 서버 주소나 요청 방식이 바뀌어도 Service만 수정하면 됨 |

## 가나디 예시

→ 가나디 앱에서 사용자의 프로필을 불러오는 상황

```txt
가나디 프로필 화면 진입
↓
View가 ProfileService에게 요청
↓
ProfileService가 서버에 API 요청
↓
서버가 JSON 응답
↓
ProfileService가 JSON을 Swift 모델로 변환
↓
View가 모델 데이터를 받아 화면에 표시
```

## Service를 쓰지 않았을 때

```swift
struct GanadiProfileView: View {
    var body: some View {
        Text("가나디 프로필")
            .onAppear {
                let url = URL(string: "https://api.ganadi.com/profile")!
                
                URLSession.shared.dataTask(with: url) { data, response, error in
                    if let data = data {
                        print(data)
                    }
                }.resume()
            }
    }
}
```

→ 이렇게 하면 View 안에 서버통신 코드가 바로 들어간다.  
처음에는 간단해 보이지만, API가 많아지면 View가 너무 복잡해진다.

## Service를 사용했을 때

```swift
import Foundation

struct GanadiProfile: Codable {
    let name: String
    let level: Int
}

final class GanadiProfileService {
    
    func fetchProfile(completion: @escaping (GanadiProfile?) -> Void) {
        guard let url = URL(string: "https://api.ganadi.com/profile") else {
            completion(nil)
            return
        }
        
        URLSession.shared.dataTask(with: url) { data, response, error in
            guard let data = data else {
                completion(nil)
                return
            }
            
            let profile = try? JSONDecoder().decode(GanadiProfile.self, from: data)
            completion(profile)
        }.resume()
    }
}
```

```swift
struct GanadiProfileView: View {
    
    let service = GanadiProfileService()
    
    var body: some View {
        Text("가나디 프로필")
            .onAppear {
                service.fetchProfile { profile in
                    print(profile?.name ?? "없음")
                }
            }
    }
}
```

## Service의 장점과 단점

| 구분 | 내용 |
|---|---|
| 장점 | 서버통신 코드가 한 곳에 모여서 관리하기 쉽다 |
| 장점 | View 코드가 깔끔해진다 |
| 장점 | 같은 API를 여러 화면에서 재사용할 수 있다 |
| 장점 | 서버 주소나 요청 방식이 바뀌어도 Service만 수정하면 된다 |
| 단점 | 파일이 늘어나서 처음에는 구조가 복잡해 보일 수 있다 |
| 단점 | 작은 프로젝트에서는 오히려 과하게 느껴질 수 있다 |
| 단점 | Service가 너무 많은 일을 하면 또 다른 거대한 파일이 될 수 있다 |

## Service 한줄 정리

Service
→ View 대신 서버통신과 데이터 처리를 담당하는 계층
