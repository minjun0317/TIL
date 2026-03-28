# 상수
➡️ 차후에 변경이 불가능한 상수


| **상수의 선언**
- 상수 선언 키워드 : let

.

```ts
let 이름: 타입 = 값
```
---
```ts
let constant: String = "변경 불가"
```

.

.

| **사용 예시**
- ☢️이름과 타입만 선언 후 나중에 값을 첫할당만 하는 것은 가능☢️
```ts
let sum: Int
let inputA: Int = 100
let inputB: Int = 200

sum = inputA + inputB // == 300
```