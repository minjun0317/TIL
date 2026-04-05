# 인스턴스의 생성과 소멸
➡️ 클래스로 만든 실제 사용 가능한 결과물 = 인스턴스
- 클래스 = 틀
- 인스턴스 = 틀로 만든 결과물
    - 인스턴스는 만들 때(init) 와 사라질 때(deinit) 가 있음

.

.

# 생성 (init)
➡️ 인스턴스가 만들어질 때 처음 값 세팅하는 단계
객체 만들면 자동 실행됨
| **사용 예시**

.

```ts
class ganadi {
    var name: String
    var age: Int
    
    init(name: String, age: Int) {
        self.name = name
        self.age = age
        
        print("가나디 생성됨")
    }
}

let dog = ganadi(name: "가나디", age: 1)
```
---

.

.

.

# 기본값
➡️ 미리 값 넣어두면 init 없어도 생성 가능

| **사용 예시**

```ts
class ganadi {
    var name = "기본가나디"
    var age = 0
}

let dog = ganadi()

print(dog.name)
//== 기본가나디
```

기본값 = 시작값이라 나중에 바꿀 수 있음

---

.

.

.

# 소멸 (deinit)
➡️ 인스턴스가 메모리에서 사라질 때 자동 실행됨
클래스에서만 가능
```ts
class ganadi {
    
    init() {
        print("가나디 등장")
    }
    
    deinit {
        print("가나디 퇴장")
    }
}

var dog: ganadi? = ganadi()

dog = nil
// 가나디 퇴장 출력됨
```
---
<details> 
<summary>정리
</summary>
init = 객체 생성될 때 실행
기본값 = 미리 넣어둔 시작값
deinit = 객체 사라질 때 실행
</details>
