# 프로퍼티 감시자
➡️ 프로퍼티 값이 변경될 때 원하는 동작을 수행할 수 있음

| **사용 예시**

```ts
var property: Type = 초기값 {
    willSet {
        // 값이 바뀌기 직전에 실행
    }
    
    didSet {
        // 값이 바뀐 직후에 실행
    }
}
```
---

.


- 곧 일어남으로 바뀜
전 - 누워있음 -> 후 - 일어남

.

```ts
struct ganadi {
    var mood: String = "누워있다" {
        willSet {
            print("곧 \(newValue)로 바뀜 ")
        }
        didSet {
            print("전 - \(oldValue) -> 후 - \(mood)")
        }
    }
}

var g = ganadi()
g.mood = "일어남"
```

연산 감시자에는 사용 ❌

⚠️ 값이 변경되기 직전에 willSet, 변경 직후에 didSet이 호출되며 둘 중 하나만 사용해도 되고, 값이 기존과 같아도 항상 실행된다