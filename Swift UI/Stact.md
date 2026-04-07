# Stack이란?

➡️ SwiftUI에서 Stack은 여러 `View`를 묶어서 하나로 배치할 때 쓰는 UI 구성요소,
body 속에 여러 View를 그냥 나열하면 안 돼서 Stack으로 감싸줘야 제대로 표시된다

.

## 📌 HStack – 수평 정렬

- 가로 방향으로 View들을 배치함
즉, 왼쪽 → 오른쪽 순서로 View가 나열

.

| **사용 예시**

```swift
HStack {
    Text("G")
    Text("A")
    Text("N")
    Text("A")
    Text("D")
    Text("I")
}
```

➡️ 출력: 
```
G A N A D I
``` 
옆으로 나열됨

.

.

---

## 📌 VStack – 수직 정렬

- 세로 방향으로 View들을 배치함
위 → 아래 순서로 나열하는

.

| **사용 예시**

```swift
VStack {
    Text("G")
    Text("A")
    Text("N")
    Text("A")
    Text("D")
    Text("I")
}
```

➡️ 출력:

```
G
A
N
A
D
I
```

줄줄이 내려오는 느낌

---

.

.


## 📌 ZStack – 겹쳐서 배치

➡️ 겹치기 방식임 즉, 앞뒤로 View들이 포개지는 스타일

| **사용 예시**

```swift
ZStack {
    Text("G")
    Text("A")
    Text("N")
    Text("A")
    Text("D")
    Text("I")
}
```

➡️ 출력: 마지막 글자인 "I"만 보여질 확률이 높음
(앞에 있는 텍스트가 뒤에 있는 걸 가려버림)

---

.

.

## Stack에 적용 가능한 Modifiers

Stack에는 몇 가지 꾸미기 옵션도 붙을 수 있음

* **Spacing** — View 사이 간격 조절
* **Alignment** — 정렬 방향 (leading, center, trailing 등)
* **Frame** — Stack 크기 지정

| **사용 예시**

```swift
HStack(alignment: .top, spacing: 20) {
    Text("G")
    Text("A")
    Text("N")
    ...
}
.frame(width: 200, height: 50)
```

→ 사이 간격 20이고, 위쪽 정렬하면서 너비 200 높이 50으로 고정됨

---

.

.

.

## 요약

| Stack 종류   | 배치 방향 | 특징           |
| ---------- | ----- | ------------ |
| **HStack** | 수평    | 좌 → 우 순서로 배치 |
| **VStack** | 수직    | 위 → 아래로 순서대로 |
| **ZStack** | 겹치기   | 앞뒤로 포개서 표시   |

Stack을 잘 쓰면 정리된 UI 레이아웃 만드는 게 훨씬 편함