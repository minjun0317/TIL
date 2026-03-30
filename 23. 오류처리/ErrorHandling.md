# 오류처리
➡️ 오류는 Error라는 포로토콜을 준수하는 타입의 값을 통해 표현한다
- Error 프로토콜은 요구사항이 없는 빈 프로토콜이지만, 오류를 표현하기 위한 타입은 이 프로토콜을 사용함

.

# 오류표현, 오류 던지기
➡️ Error와 열거형으로 오류를 표현

- 연관값을 사용하여 오류의 추가 정보를 전달 가능하다

| **사용 예시**

```ts
enum ganadiError: Error {
    case toocute(level: Int)
}

func eat() throws//== throws는 오류 잇을수도 있다고 
{
    throw ganadiError.toocute(level: 5)
    //== throws 오류 던지기
}

do {
    look see()
} catch ganadiError.toocute(let level) {
    print("가나디의 귀여움 수치는? = \(level)")
}
```

**= 만들고 (enum) -> 던지고 (throw) -> 잡는다 (catch)**

###### 이처럼 오류 발생의 여지가 있는 메서드는 throws를 사용, 오류를 던질수도 있지만 이에 대비하여 던져진 오류를 처리하기 위한 코드도 작성해야함 예를 들어 던져진 오류가 무엇인지 판단하여 다시 문제를 해결한다든지, 다른 방법으로 시도해본다든지 사용자에게 오류를 알리고 사용자에게 선택 권한을 넘겨주어 다음에 어떤 동작을 하게 할 것인지 결정하도록 유도하는 등의 코드를 작성해야 함!
---

.

.

.

# 오류 타입 지정
➡️ 오류는 Error 프로토콜을 따르는 값, 어떤 오류가 날지 알 수 없음
- 타입 제한 없이 오류 던지기 (`throws`)를 사용

| **사용 예시**

```ts
//모든 에러 가능 (any Error)

func test() throws(any Error) {
    throw MyError.somethingWrong
}

func ganadiTest() throws(any Error) {
    throw GanadiError.leashLost
}


//특정 에러만 가능 (typed throws)

func test() throws(MyError) {
    throw MyError.somethingWrong
}

func ganadiTest() throws(GanadiError) {
    throw GanadiError.leashLost
}
```