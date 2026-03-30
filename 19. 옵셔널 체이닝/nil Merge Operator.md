# nil 병합 연산자
➡️ nil 값의 경우에는 특정 타입에 대한 값의 부재를 보여주는 것임

| **사용 예시**

```ts
var name: String? = nil

let result = name ?? "기본값"
print(result) 
//== 기본값
```