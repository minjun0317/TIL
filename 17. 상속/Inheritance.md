# 상속
➡️ 클래스가 다른 클래스의 속성과 메서드를 물려받아 재사용할 수 있게 해주는 객체 지향 프로그래밍의 중요한 개념이다
| **사용 예시**

```ts
class 부모클래스 {
    속성
    메서드
}

class 자식클래스: 부모클래스 {
    추가 기능
}
```
---

.
- Dog 클래스는 Animal을 상속받아 부모의 속성과 메서드를 그대로 사용하면서, bark() 같은 기능을 추가

.

```ts

class pganadi {
    var name: String = ""
    
    func do() {
        print("똥 싸는 중")
    }
}
//== 부모 클래스

class bganadi: pganadi {
    func sound() {
        print("뿌지직")
    }
}
//== 자식 클래스 (상속)
//== 사용
let Bganadi = bganadi()

Bganadi.name = "더러워" 
Bganadi.do()         
Bganadisound()        
```
---

.

.

.
# 재정의
➡️ 부모 클래스가 가지고 있는 기능을 자식 클래스에서 다시 정의하는 것
- 속성 재정의
    - 서브 클래스는 슈퍼 클래스의 속성을 재정의하여 자신만의 구현을 제공할 수 있음 계산 속성을 재정의 할 때는 `override` 키워드 사용한다

| **사용 예시**

.

```ts
class ch {
    var name: String {
        return "세상에서 가장귀여운건"
    }
}

class i: ch {
    override var name: String {
        return "가나디"
    }
}

let I = i()
print(I.name)
//== 가나디
```
---
.

.

.

# 메서드 재정의
➡️ 서브 클래스는 슈퍼 클래스의 메서드를 재정의하여 자신만의 구현을 제공할 수 있음 메서드를 재정의 하려면 `override` 키워드 사용한다

| **사용 예시**

```ts
class ganadi {
    func speak() {
        print("강아지는 월월 가나디는")
    }
}

class Dog: ganadi {
    override func speak() {
        print("듀듀")
    }
}

let dog = Dog()
dog.speak()
```
---

.

.

.

# super 키워드
➡️ super 키워드는 서브 클래스에서 슈퍼 클래스의 속성과 메서드를 참조할 때 사용, super를 사용하여 슈퍼 클래스의 메서드를 호출하거나 속성에 접근 가능하다

---

.

.

.

<details>
<summary>정리하기
</summary>

- 상속 = 다른 클래스의 속성과 메서드를 물려받아 재사용하는 것
- 재정의 = 서브 클래스에서 슈퍼 클래스의 계산 속성 및 메서드를 재정의하는 것
- `super` 키워드 = 서브 클래스에서 슈퍼 클래스의 속성과 메서드를 참조할 때 사용
</details>
<br>
⚠️ 상속을 사용하면 코드의 재사용성을 높이고, 더 간결하고 유지보수하기 쉬운 코드를 작성할 수 있음
