# Optional Unwrapping ( 옵셔널 값 추출 )
- 옵셔널 꺼내는 방법
    - Optional Binding ( 옵셔널 바인딩 )

    - Force Unwrapping ( 강제 추출 )

.

.

|Optional Binding|Force Unwrapping|
|:---|:---|
|nil을 체크|강제 추출 시 값이 없으면 런타임 오류 발생|
|if-else 방식을 사용하여 해줄 수 있음|nil의 값이 전달되기 때문에 런타입 오류 발생|
|name 상수는 if-let 구문 내에서만 사용 가능||
|상수 사용 범위를 벗어나면 컴파일 오류 발생||

## Optional Binding ( 옵셔널 바인딩 )
- 값이 있는지 없는지 체크하여 값을 꺼낼지 말지 정하는 방식이기에 안정성이 높다

| **사용 예시**

```ts
var ganadi: String? = "가나디좋아"

if let a = ganadi {
    print("꺼낼 값 = ", a)
} 

else {
    print("값이 없음")
}
//== 꺼낼 값 = 가나디좋아
```
---

.

```ts
var ganadi: String? = nil

if let a = ganadi {
    print("꺼낼 값 = ", a)
} 

else {
    print("값이 없음")
}
//== 꺼낼 값 = 값이 없음
```
---

.

.

.

## Force Unwrapping ( 강제 추출 )
- 강제 추출함

| **사용 예시**

```ts
var ganadi: String? = "가나디좋아"

print( ganadi! )
//== 가나디좋아
```
---

.

```ts
var ganadi: String? = nil

print( ganadi! )
//== 오류 ( 강제 추출했지만 값이 없기때문에 왜 꺼냈냐며 오류가 발생함 )
```