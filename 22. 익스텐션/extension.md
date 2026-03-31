# 익스텐션 ( extension )
➡️ 구조체, 클래스, 열거형, 프로토콜 타입에 새로운 기능을 추가 할 수 있는 기능

- 연산 타입 프로퍼티, 연산 인스턴스 프로퍼티
- 서브스크립트
- 중첩 타입
- 이니셜라이저
- 타입 메서드, 인스턴스 메서드

.

.

.

# 연산 프로퍼티 추가
➡️ extension를 사용한다

| **사용 예시**

```ts
// 기본 구조체
struct ganadi { 
    var food: Int 
}

extension ganadi { 
    var isHappy: Bool {
        return food > 0
    }
}
```

### 메서드 추가
- 익스텐션을 통해 Int에 인스턴스 메서드인 multiply(by:) 메서드를 추가한다
