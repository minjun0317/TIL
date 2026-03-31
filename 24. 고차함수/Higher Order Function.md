# 고차함수 (Higher-Order Function)
➡️ 함수를 값처럼 사용하는 함수, 함수를 파라미터로 전달 가능, 함수가 함수를 반환 가능
Swift에서는 **클로저(closure)***기반으로 많이 사용

---

.

# map
➡️ 배열의 각 요소를 변형해서 새 배열 생성, 기존 배열은 변경되지 않음, 요소 개수 유지, 많이 쓰는 변환 함수

| **사용 예시**

```ts
let numbers = [1,2,3,4]

let result = numbers.map { num in
    num * 2
}

print(result)
//== [2,4,6,8]
```
---
```ts
let ganadiAge = [1,2,3]

let result = ganadiAge.map { age in
    age + 1
}
```
.

# filter
➡️ 조건에 맞는 요소만 추출, true 인 요소만 남김,배열 크기 줄어들 수 있음

| **사용 예시**

```ts
let numbers = [1,2,3,4,5]

let result = numbers.filter { num in
    num % 2 == 0
}

print(result)
//== [2,4]
```
---

```ts
let ganadiAge = [1,2,3,4,5]

let result = ganadiAge.filter { age in
    age >= 3
}
```

.

# reduce
➡️ 배열 요소를 하나의 값으로 합침, 누적값(accumulator) 사용

| **사용 예시**

```ts
let numbers = [1,2,3,4]

let result = numbers.reduce(0) { result, num in
    result + num
}

print(result)
//== 10
```
---

```ts
let snack = [1,2,3]

let total = snack.reduce(0) { sum, count in
    sum + count
}
```

.

# compactMap
➡️ nil 제거 + 변환, Optional 값 제거할 때 많이 사용

| **사용 예시**

```ts
let arr = ["1","2","hi","3"]

let result = arr.compactMap { Int($0) }

print(result)
//== [1,2,3]
```
.

# flatMap
➡️ 중첩 배열 펼치기

| **사용 예시**

```ts
let arr = [[1,2],[3,4]]

let result = arr.flatMap { $0 }

print(result)
//== [1,2,3,4]
```
.

<details>
<summary>정리
</summary>

|함수|기능|
|:---|:---|
|map|값 변형|
|filter|조건 맞는 값만|
|reduce|하나의 값으로 합침|
|compactMap|nil 제거 + 변형|
|flatMap|배열 펼치기|
</deatils>