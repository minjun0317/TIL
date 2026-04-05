# Guard 구문
➡️ 디버깅 모드 뿐만 아니라 어떤 조건에서도 동작하며, guard를 사용해 잘못된 값을 전달 시 특정한 실행구문을 종료시킨다
- 지시어 return, break가 필수이다
- 타입 캐스팅, 옵셔널과도 자주 사용한다

```ts
func ganadiage(age: nil) {
    guard let age = age else {
        print("나이없음")
        return
    }
    
    print("가나디나이는:", age)
}
//== 나이없음
```