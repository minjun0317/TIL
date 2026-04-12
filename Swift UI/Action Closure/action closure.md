# Action Closure
➡️ 버튼을 눌렀을 때 실행되는 코드 블럭

# Button View
➡️ 사용자가 상호작용을 할 수 있는 요소로, 다양한 스타일과 모디파이어를 사용하여 쉽게 커스텀 가능하다
    
- 모디파이어 = 뷰의 속성을 변경하거나 스타일 적용및 기능 추가에 사용되는 컴포넌트 


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
    Button(action: self.didTapButton) { // <-
      Text("MyButton")
    }
  }
  
  func didTapButton() {
    print("tap button!")
  }
  }
```