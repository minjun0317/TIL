# 열거형
➡️ 정해진 선택지 중 하나만 선택하는 타입

| **사용 예시**
- `enum`은 타입이므로 Upper Camel Case를 사용한다
- 각 case는 Lower Camel Case로 정의
- 각 case는 그 자체가 고유의 값

.

.

.

```ts
enum 이름 {
	case 이름1
	case 이름2
}
```
---

.

```ts
enum ganadi {
    case gganadi
    case gannadi
    case ganaddi
}

var mood: ganadi = .ganaddi

switch mood {
case .gganadi:
    print("까나디")
case .gannadi:
    print("가냐디")
case .ganaddi:
    print("가나띠")
}
//== 가나띠
```
---

.

.

# 원시값
➡️ C 언어의 `enum`처럼 rawValue를 사용해 정수값을 가질 수도 있다, case 별로 각각 다른 값을 가져야함

| **사용 예시**
- 각 case에 숫자 같은 값을 직접 연결해서 사용할 수 있음

.

```ts
enum ganadi: Int {
    case happylevel = 10
    case sadlevel = 4
}

let level = ganadi.happylevel
print(level.rawValue)
//== 10
```
---

.

.

.

# 메서드
➡️ 스위프트의 열거형에는 메서드도 추가 가능

| **사용 예시**
- 열거형 안에서도 메서드를 정의할 수 있으며, 각 케이스에 따라 다른 동작을 수행

```ts
enum ganadi {
    case gganadi
    case gannadi
    case ganaddi
    
func description() -> String {
    switch self {
    case .gganadi:
        return "까나디"
    case .gannadi:
        return "가냐디"
    case .ganaddi:
        return "가나띠"
    }
 }
}

let m = ganadi.happy
print(m.description())
```