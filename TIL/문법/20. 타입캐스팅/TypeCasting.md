# 타입 캐스팅 (Type Casting)
➡️ 인스턴스의 실제 타입을 확인하거나 해당 인스턴스를 부모 클래스 또는 자식 클래스로 취급하는 방법
- Swift에서는 is, as, as?, as! 연산자를 사용한다.

| **사용 예시**
```ts
class ganadi { }

class gannadi: ganadi {
    func burk() {
        print("멍!")
    }
}

class ganaddi: ganadi {
    func sleep() {
        print("쿨...")
    }
}
```
---

.

.

.

# 업 캐스팅 (Up Casting)
➡️ 자식 클래스 인스턴스를 부모 클래스 타입으로 변환
- 사용 연산자: as
    - 항상 성공 (안전), 대부분 자동으로 처리되므로 생략 가능

| **사용 예시**
```ts
let g = gannadi()

let animal: ganadi = g as ganadi
// 보통은 아래처럼 작성
let animal2: ganadi = g
```
자식 → 부모

---

.

.

.

# 다운 캐스팅 (Down Casting)
➡️ 부모 타입으로 저장된 인스턴스를 다시 자식 타입으로 변환
- as? 또는 as! 사용
    - 실제 타입이 일치해야 성공

| **사용 예시**
```ts
let animal: ganadi = gannadi()

if let dog = animal as? gannadi {
    dog.burk()
}
```
부모 → 자식

---
.

.

# 조건부 다운 캐스팅
➡️ as? 사용
- 실패하면 nil 반환 → 옵셔널 타입

| **사용 예시**
```ts
let animal: ganadi = gannadi()

let dog = animal as? gannadi

if let dog = animal as? gannadi {
    dog.burk()
}
```
안전함, 실패 가능성 있을 때 사용

---

.

.

# 강제 다운 캐스팅
➡️ as! 사용
- 실패하면 런타임 오류 발생

| **사용 예시**
```ts
let animal: ganadi = gannadi()

let dog = animal as! gannadi
dog.burk()
```
타입이 확실할 때만 사용, 실패 시 앱 종료