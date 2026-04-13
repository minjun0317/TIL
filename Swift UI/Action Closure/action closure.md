# Action Closure
➡️ 버튼을 눌렀을 때 실행되는 코드 블럭

# Button View
➡️ 사용자가 상호작용을 할 수 있는 요소로, `Button` 구조체를 사용하여 생성,  다양한 스타일과 모디파이어를 사용하여 쉽게 커스텀 가능하다
    
- 모디파이어 = 뷰의 속성을 변경하거나 스타일 적용및 기능 추가에 사용되는 컴포넌트

|Action|버튼이 눌렸을 때 실행되는 클로저|
|:---:|:---|
|Label|버튼의 외형을 정의하는 뷰|


| **사용 예시**

- Button안에 텍스트를 적고 closure에 action을 기입

.

```Swift
Button("Ganadi Button") 
{ print("Cute ganadi") } //== 이게 Action closure
```
---

-  action을 앞에서 받고 텍스트를 넣어서 표현 가능
    - 색상은 skyblue가 기본값

.

```Swift
Button(action: { print("Tap Ganadi") }) {
    Text("oh! what are you doing?")
}
```
---

- action에 일반 func 함수도 표현 가능

.

```Swift
struct ContentView: View {
  var body: some View {
    Button(action: TapGanadiButton) { // == <-
      Text("Ganadi Button")
    }
  }
  
  func TapGanadiButton() {
    print("oh! what are you doing?")
  }
  }
```

.

.

.

# Button Style
➡️ .buttonStyle()으로 지정 가능하며, buttonStyle 프로토콜을 준수하는 Struct 인스턴스를 .buttonStyle()안에 주입하면 적용되는데, 이 때 자유롭게 버튼을 커스텀하여 사용이 가능
- .default : 파란색 버튼

- .plain : 일반 Text 형태 그대로 따라가는 버튼
- .bordered : 버튼의 tint색상을 기반으로 자동으로 테두리에 어울리는 색상이 생기는 버튼
- .borderedProminent : 버튼의 tint색상을 기반으로 텍스타가 눈에 띄도록 해주는 스타일
- .borderless : 테두리가 없는 버튼(//== .default와 동일)

| **사용 예시**
```Swift
VStack {
  Button("ganadi") { }
  .buttonStyle(.automatic) 
  // default

  Button("Ganadi") { }
  .buttonStyle(.plain) 
  // default

  Button("GaNaDi") { }
  .buttonStyle(.bordered)

  Button("GANADI") { }
  .buttonStyle(.borderedProminent)

  Button("GanadI") { }
  .buttonStyle(.borderless)
}
.tint(.purple)
```