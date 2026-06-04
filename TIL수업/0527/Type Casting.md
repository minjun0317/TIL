# Type Casting

## Type Casting이란?

Type Casting은 객체의 실제 타입을 확인하거나 다른 타입으로 변환해서 사용하는 기능

iOS 개발에서는 부모 타입으로 받은 객체를 실제 타입으로 변환해야 하는 경우가 많아서 자주 사용

예를 들어

- UIViewController 화면 전환
- UITableViewCell 커스텀 셀 사용
- UICollectionViewCell 커스텀 셀 사용
- Any 타입 데이터 처리
- Protocol 타입 확인

등에서 자주 사용

---

## 왜 사용할까?

예를 들어 HomeViewController는 UIViewController를 상속받음

swift let vc: UIViewController = HomeViewController() 

실제 객체는 HomeViewController

하지만 변수 타입은 UIViewController

그래서 HomeViewController에만 있는 기능은 사용할 수 없음

swift vc.fetchUser() 

오류 발생

UIViewController에는 fetchUser()가 없기 때문

---

## Downcasting으로 해결

swift if let homeVC = vc as? HomeViewController {     homeVC.fetchUser() } 

HomeViewController 타입으로 변환한 뒤 전용 기능 사용 가능

---

# Upcasting

## 개념

자식 타입을 부모 타입으로 사용하는 것

swift let homeVC = HomeViewController()  let vc: UIViewController = homeVC 

HomeViewController는 UIViewController를 상속받기 때문에 가능

Swift에서는 자동으로 처리

---

## 실무 예제

swift let viewControllers: [UIViewController] = [     HomeViewController(),     ProfileViewController(),     SettingViewController() ] 

서로 다른 화면을 하나의 배열로 관리 가능

---

# Downcasting

## 개념

부모 타입을 자식 타입으로 변환하는 것

swift let vc: UIViewController = HomeViewController() 

현재는 UIViewController 타입으로 인식

따라서 HomeViewController 전용 기능 사용 불가

---

## 예제

swift if let homeVC = vc as? HomeViewController {     homeVC.fetchUser() } 

---

# as

## 개념

업캐스팅이나 타입이 확실한 경우 사용

swift let homeVC = HomeViewController()  let vc = homeVC as UIViewController 

실무에서는 업캐스팅할 때 Swift가 자동으로 처리하기 때문에 많이 보이지는 않음

---

# as?

## 개념

안전한 다운캐스팅

실패하면 nil 반환

swift if let homeVC = vc as? HomeViewController {     homeVC.fetchUser() } 

---

## 특징

- 실패 시 nil
- 앱 종료 안 됨
- 실무에서 가장 많이 사용

---

## UITableViewCell 예제

swift guard let cell = tableView.dequeueReusableCell(     withIdentifier: "UserCell",     for: indexPath ) as? UserTableViewCell else {     return UITableViewCell() }  return cell 

---

# as!

## 개념

강제 다운캐스팅

실패하면 앱이 바로 종료됨

swift let homeVC = vc as! HomeViewController 

---

## 특징

- 코드가 짧음
- 실패 시 크래시
- 실무에서는 신중하게 사용

---

## 예제

swift let loginVC = storyboard?.instantiateViewController(     withIdentifier: "LoginViewController" ) as! LoginViewController 

클래스 연결이 잘못되어 있으면 앱 종료

---

# as? 와 as!

| 구분 | as? | as! |
|--------|--------|--------|
| 실패 | nil | 크래시 |
| 안정성 | 높음 | 낮음 |
| 실무 사용 | 많음 | 적음 |

---

# is

## 개념

타입만 확인하는 연산자

swift if vc is HomeViewController {     print("HomeViewController") } 

---

## 특징

- 타입 확인만 수행
- 변환은 하지 않음
- 반환값은 Bool

---

## 예제

swift if vc is LoginViewController {     print("로그인 화면") } 

---

# is 와 as?

| 구분 | is | as? |
|--------|--------|--------|
| 타입 확인 | O | O |
| 타입 변환 | X | O |
| 반환값 | Bool | Optional |

---

# Any

## 개념

모든 타입을 저장할 수 있는 타입

swift var value: Any  value = "민준" value = 17 value = true value = UIView() 

모두 가능

---

## 꺼낼 때

실제 타입을 모르기 때문에 캐스팅 필요

swift if let name = value as? String {     print(name) } 

---

## 실무 예제

swift let data: [Any] = [     "민준",     17,     true ] 

---

# AnyObject

## 개념

클래스 타입만 저장 가능

swift var object: AnyObject  object = UIView() object = UIViewController() object = UIImageView() 

---

## 불가능한 예제

swift object = "민준" object = 17 object = true 

값 타입이라 저장 불가

---

# Any 와 AnyObject

| 구분 | Any | AnyObject |
|--------|--------|--------|
| String | O | X |
| Int | O | X |
| Bool | O | X |
| UIView | O | O |
| UIViewController | O | O |

---

# 실무 예제

## UITableViewCell

swift guard let cell = tableView.dequeueReusableCell(     withIdentifier: "UserCell",     for: indexPath ) as? UserTableViewCell else {     return UITableViewCell() }  cell.configure() return cell 

dequeueReusableCell의 반환 타입은 UITableViewCell

커스텀 기능을 사용하려면 UserTableViewCell로 변환해야 함

---

## UICollectionViewCell

swift guard let cell = collectionView.dequeueReusableCell(     withReuseIdentifier: "ProfileCell",     for: indexPath ) as? ProfileCollectionViewCell else {     return UICollectionViewCell() }  return cell 

---

## Storyboard 화면 전환

swift guard let profileVC = storyboard?     .instantiateViewController(         withIdentifier: "ProfileViewController"     ) as? ProfileViewController else {     return }  profileVC.userID = 1  navigationController?.pushViewController(     profileVC,     animated: true ) 

---

# 정리

- Type Casting은 객체의 실제 타입을 확인하거나 변환하는 기능
- Upcasting은 자식 타입을 부모 타입으로 사용하는 것
- Downcasting은 부모 타입을 자식 타입으로 변환하는 것
- as?는 실패 시 nil을 반환하는 안전한 캐스팅
- as!는 실패 시 앱이 종료되는 강제 캐스팅
- is는 타입만 확인
- Any는 모든 타입 저장 가능
- AnyObject는 클래스 타입만 저장 가능
- UITableViewCell, UICollectionViewCell, Storyboard 화면 전환에서 매우 자주 사용