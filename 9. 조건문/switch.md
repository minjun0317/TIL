# switch 구문
➡️ 패턴 기반으로 switch 구문은 다른 언어에 비해 힘이 세다

| **사용 예시**
- 기본 타입들을 지원하며 다른 패턴들과도 사용 가능하다
    - case마다 자동으로 break가 실행됨
    - 쉼표로 여러 패턴은 명시 가능함
    - 반드시 실행 가능성이 있는 코드가 위치 해야함

.

.

.

```ts
let menu = "나이키"

switch menu {

case "후드":
    print("아디다스 가서 후드 사자")
case "맨투맨":
    print("아디다스 가서 맨투맨 사자")
default:
    print("그냥 가나디 티셔츠 사자")
}
//== 그냥 가나디 티셔츠 사자 
```
---

.

.

# where 절을 사용해서 조건을 지정할 수 있다

 ```swift
 let score = 75 

switch score {
case let x where x >= 90: 
    print("A")
case let x where x >= 80: 
    print("B")
case let x where x >= 70:
    print("C")
default:
    print("F")
}
//== C
```