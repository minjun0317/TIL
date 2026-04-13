# Navigation View ( NavigationStack )
➡️ 화면 간 이동(네비게이션)을 관리하는 컨테이너 뷰

- iOS 16 이후에는 `NavigationView` 대신 `NavigationStack` 사용 권장
- 계층적인 화면 이동( push / pop )을 구현할 수 있음

---

.

.

## 기본 구조
➡️ NavigationStack 안에 View를 넣고, NavigationLink로 화면 이동

| **사용 예시**

```swift
NavigationStack {
    NavigationLink("Go to ganadi") {
        Text("Ganadi View")
    }
}
```

---

.

.

.

# NavigationLink
➡️ 다른 화면으로 이동할 수 있는 버튼 역할

|    구성 요소    | 설명            |
| :---------: | :------------ |
|    Label    | 사용자에게 보여지는 UI |
| Destination | 이동할 목적지 View  |

.

---

| **사용 예시**

```swift
NavigationStack {
    NavigationLink("Ganadi Detail") {
        Text("Welcome Ganadi")
    }
}
```

---

.

.

## Label 커스텀

| **사용 예시**

```swift
NavigationStack {
    NavigationLink(destination: Text("Ganadi View")) {
        Text("Go to ganadi")
            .font(.title)
            .foregroundColor(.white)
    }
}
```

---

.

.

.

# Navigation Title

➡️ 상단 네비게이션 바 제목 설정

| **사용 예시**

```swift
NavigationStack {
    Text("Ganadi View")
        .navigationTitle("Ganadi's Home")
}
```

---

.

.

.

## Navigation Bar Display Mode

➡️ 제목 스타일 설정

| **사용 예시**

- `.automatic`
- `.inline` -> 작은 타이틀
- `.large` -> 큰 타이틀 (기본))


```swift
.navigationBarTitleDisplayMode(.inline)
```

---

.

.

## Toolbar

➡️ 네비게이션 바에 버튼 추가

| **사용 예시**

```swift
NavigationStack {
    Text("Ganadi View")
        .navigationTitle("Ganadi's Home")
        .toolbar {
            ToolbarItem(placement: .navigationBarTrailing) {
                Button("Add") {
                    print("Add ganadi tapped")
                }
            }
        }
}
```

---

.

.

# 화면 전환 (Push 방식)

➡️ NavigationLink를 통해 Stack에 쌓이며 이동

```swift
NavigationStack {
    VStack {
        NavigationLink("Go Next") {
            SecondView()
        }
    }
}

struct SecondView: View {
    var body: some View {
        Text("Second View")
    }
}
```

---

.

.

.

# 데이터 전달

```swift
NavigationStack {
    NavigationLink {
        DetailView(name: "Ganadi")
    } label: {
        Text("Go Detail")
    }
}

struct DetailView: View {
    let name: String
    
    var body: some View {
        Text("\(name)")
    }
}
```

---

# NavigationStack + Path (고급)

➡️ 데이터 기반 네비게이션 관리

```swift
struct ContentView: View {
    @State private var path = [String]()
    
    var body: some View {
        NavigationStack(path: $path) {
            VStack {
                Button("Go Detail") {
                    path.append("Ganadi")
                }
            }
            .navigationDestination(for: String.self) { value in
                Text(value)
            }
        }
    }
}
```

---

# NavigationView (구버전)

➡️ iOS 15 이하에서 사용 (현재는 비추천)

```swift
NavigationView {
    NavigationLink("Go Detail") {
        Text("Detail View")
    }
}
```

---

# 핵심 정리

* `NavigationStack` 👉 최신 네비게이션 방식
* `NavigationLink` 👉 화면 이동 트리거
* `navigationTitle()` 👉 상단 타이틀
* `toolbar()` 👉 버튼 추가
* `path` 👉 상태 기반 네비게이션 관리
