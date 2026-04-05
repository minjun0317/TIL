# SwiftUI 개요 정리

.

## 선언형(Declarative) UI란?

➡️ SwiftUI는 사용자 인터페이스(UI)를 **선언형 방식**으로 설계합니다.

### 명령형 vs 선언형

| 방식                    | 특징                                   |
| --------------------- | ------------------------------------ |
| **명령형 (Imperative)**  | 뷰 생성, 배치, 상태 변화에 따른 업데이트를 직접 코드로 관리 |
| **선언형 (Declarative)** | 원하는 UI 상태를 선언하면 프레임워크가 자동으로 업데이트 처리 |
<br>

➡️ 선언형 방식에서는 UI의 구조를 **간단하게 설명(lightweight description)** 하면,
SwiftUI가 사용자 입력이나 상태 변화에 따라 자동으로 화면을 다시 그립니다.


- 고등학생 **ganadi**의 앱 화면에 아래 문장이 보이도록 만들고 싶다고 가정합니다.

```
안녕, ganadi!
오늘도 밤샘 화이팅!
```

⚠️ SwiftUI에서는 화면을 만드는 방법이 아니라 **원하는 결과 모습**을 작성합니다.

---

.

.

.

## SwiftUI의 역할

SwiftUI는 UI를 구성하기 위한 다양한 도구를 제공합니다.

* 내장 뷰 제공 (`Text`, `Toggle`, `ProgressView` 등)
* 뷰 조합을 통한 커스텀 뷰 생성 가능
* modifier를 통해 뷰 속성 변경
* 데이터 모델과 연결 가능

---

.

.

.

# View 프로토콜

➡️ SwiftUI에서 커스텀 뷰를 만들려면 **View 프로토콜**을 따라야 합니다.

| **사용 예시**

- View 프로토콜은 화면에 표시될 요소의 동작을 정의합니다.

.

```ts
struct GanadiView: View {
}
```



---

.

.

.

# body 프로퍼티

➡️ View 프로토콜을 따르기 위해 반드시 `body` 프로퍼티를 구현해야 합니다.

| **사용 예시**

```ts
struct GanadiView: View {

    var body: some View {

    }

}
```

- 특징

    * `body`는 계산 프로퍼티(computed property)
    * SwiftUI는 상태 변화 시 `body`를 다시 호출하여 UI 업데이트
    * 반환 타입은 `some View` (불투명 타입, opaque type)
    * 실제 타입은 Swift가 자동 추론

---

.

.

.

# 기본 뷰 구성
.

## Text 뷰

| **사용 예시**

```ts
struct GanadiView: View {

    var body: some View {

        Text("안녕, ganadi!")

    }

}
```

---

.

.

.

## VStack을 이용한 레이아웃

| **사용 예시**

```ts
struct GanadiView: View {

    var body: some View {

        VStack {

            Text("안녕, ganadi!")

            Text("오늘도 공부 화이팅!")

        }

    }

}
```

➡️  여러 뷰를 나열할 수 있는 이유는 `ViewBuilder` 덕분입니다.
    
* 여러 줄의 클로저 사용 가능
* 별도 문법 없이 뷰를 순서대로 작성하면 됨

---

.

.

.

# Modifier (수정자)

➡️ 뷰의 속성을 변경할 때 사용합니다.

- modifier는 **기존 뷰를 변경하는 것이 아니라 새로운 뷰를 반환**합니다.

| **사용 예시**

```ts
struct GanadiView: View {

    var body: some View {

        VStack {

            Text("안녕, ganadi!")
                .font(.title)

            Text("오늘도 공부 화이팅!")

        }

    }

}
```

- 특징

    * 메서드 체이닝 방식
    * 모든 View 타입에 적용 가능
    * UI 스타일 변경에 자주 사용

- 예시 modifier

    * `.font()`
    * `.padding()`
    * `.background()`
    * `.foregroundColor()`

---

.

.

.

# 데이터 전달

➡️ 뷰에 값을 전달하려면 속성을 정의합니다.

| **사용 예시**

```ts
struct GanadiView: View {

    let name: String

    var body: some View {

        VStack {

            Text("안녕, \(name)!")
                .font(.title)

            Text("오늘도 공부 화이팅!")

        }

    }

}
```
---
```swift
GanadiView(name: "ganadi")
```

- 핵심 개념

    * 값이 변경되면 SwiftUI가 자동으로 UI 업데이트
    * 필요한 부분만 다시 렌더링
    * 뷰 초기화 시 무거운 작업은 피하는 것이 좋음

⚠️ Swift는 기본적으로 **member-wise initializer**를 자동 생성합니다.

---

.

.

.

# 뷰 계층에 추가하기

➡️ 다른 뷰 안에 커스텀 뷰를 포함할 수 있습니다.

| **사용 예시**

```ts
struct ContentView: View {

    var body: some View {

        GanadiView(name: "ganadi")

    }

}
```

사용 가능한 위치:

* 앱의 루트 뷰
* 설정 화면(Settings Scene)
* 알림 화면(Notification Scene)
* 다른 커스텀 뷰 내부

---

# 핵심 요약

* SwiftUI는 선언형 UI 프레임워크
* View 프로토콜을 따라 커스텀 뷰 생성
* body 프로퍼티에 UI 구조 작성
* VStack 등으로 레이아웃 구성
* modifier로 스타일 변경
* 속성(property)으로 데이터 전달
* 다른 뷰 안에 자유롭게 포함 가능

