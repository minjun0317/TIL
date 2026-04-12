# 옵셔널 체이닝
➡️ 체이닝을 이용하여 옵셔널에 접근 하는 것으로 연속적인 옵셔널들을 연쇄적으로 확인 해보는 것

.

.

.

# 종류
- `Force unwrapping` : !를 써서 강제로 추출
- `Optional Binding` : `if let`, `guard let`을 써서 추출
- `Optional Chaining` : 체이닝의 형태처럼 연쇄적으로 옵셔널에 접근
---

.

.

# 옵셔널 바인딩 (if-let)

| **사용 예시**

```ts
var name: String? = "가나디"

if let unwrapped = name {
    print(unwrapped)
} else {
    print("값 없음")
}
```
---

.

- 옵셔널 바인딩 + 옵셔널 체이닝

.

```ts
class ganadi {
    var name: String?
}

var ganadi: Ganadi? = Ganadi()
ganadi?.name = "가나디"

if let name = Ganadi?.name {
    print(name)
}
```