# String
➡️ 문자열 타입, 유니코드를 사용하기 때문에 유니코드로 표현할 수 있는 모든 문자열들을 표현할 수 있다

| **사용 예시**

- 문자열

.

```ts
let korean: Character = 오늘은 잠을 많이 잤어요
```

- 여러줄 문자열

.

```ts
let korean: Character = """
자고
일어났더니
하루가 지나있는
매직~
"""
```

- 문자열 보간법

.

```ts
let language = "Swift"
let version = 7
let sum = "\\(language) \\(version).0"
//== Swift 7.0
```