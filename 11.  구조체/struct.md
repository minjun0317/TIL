# 구조체
➡️ 구조체는 값을 저장하고 조작하는데 사용되는 사용자 정의 데이터 타입, 구조체는 여러 변수 또는 상수과 메서드를 포함할 수 있음

| **사용 예시 ( 기본 문법 )**
- 구조체는 `struct` 키워드를 사용하여 정의
- 중괄호 `{}` 안에 속성과 메서드를 작성

.

.

```ts
struct 구조체이름 {
    속성 및 메서드 정의
}
```
---

.

```ts
struct ganadi {
    var name: String
     var age: float
}

let ganadi = ganaddi( name: "가나띠", age: 2.6 )
print(ganadi.name)
print(ganadi.age) 
//== 가나띠
//== 2.6
```

⚠️ 구조체는 값 타입으로 Upper Camel Case를 사용해야함