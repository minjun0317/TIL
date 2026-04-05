Swift 수업

# 선언형(Swift Ui)

### 장점

- 중간과정 생략,  자동처리
- 코드가 짧음, 즉 직관적이다

### 단점

- 개발속도가 빠르다
- 디테일 부족(과정을 생략하기 떄문에 디테일 수정이 힘듬)
	- 위치선언 부족

.

```
vstack{
text(“hello”)
text(“시우”)
}
```
- 스유로 애니메이션 등 구현힘듬

Ex)
Text(“hello”)	 // C언어의 print와 같게 생갹하면 안됨
	font(suit)

.

.

.

# 명령형(Swift Ui Kit)
- hello를 하기까지 최소 2줄 이상
- 애니메이션 등 복잡하고 세밀한 구현 가능

Ex) 
let.label = UILabel
label.text = “hello”
label.font = system.suit
view.addsubview(label)
---

.

.

.

# Struct

- 간단한 계산식이라도 넣으면 안됨
계산을 해서 상태가 바뀌면, 즉 상태변경 다시 호출해야 해서 무한반복이 되버린다
- view에서 Myview로 읽음

```
struct MyView: View {}
: 는 = 임
```

- 계산식을 넣으려면 다른 struct를 생성해야함!
```
struct logic {}
```
---

.

.

.

# body 선언하기
- var는 사용 ㄴㄴ 계속 읽기 때문에 흐름이 바꼉
- some view = 불투명타입
- some 비슷한 any 즉, 대충대충 
```
var body: some view {

}
```
---
```
struct myview: view {
    var body: some view {
        text("가나디")
    }
}
```
---

.

.

.

# 뷰 콘텐츠 구성하기
```
struct myview: view {
    text("가나디") //== view
    text("ganadi") //== view
}
```
---
```
//view

let.label = UIlabel()
label.text - ("hello")
```
---
```
struct myview: view {
    var body: some body {
        vstack {
            text("가나디")
            .font(suit)//== 수정자(외우기)
        }
    }
}
```
---

클로저 = 문법 X

.

.

.

# 데이터관리하기ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ

