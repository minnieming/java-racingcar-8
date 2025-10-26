# java-racingcar-precourse

# 🚗 자동차 경주

---

## 📋 과제 진행 요구 사항

- 미션은 **자동차 경주 저장소를 포크하고 클론**하는 것으로 시작한다.
- 기능을 구현하기 전 `README.md`에 **구현할 기능 목록**을 정리해 추가한다.
- **Git의 커밋 단위**는 앞 단계에서 작성한 기능 목록 단위로 추가한다.
- **커밋 메시지**는 [AngularJS Git Commit Message Conventions](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#commits)을 참고한다.
- 자세한 과제 진행 방법은 **프리코스 진행 가이드 문서**를 참고한다.

---

## ⚙️ 기능 요구 사항

> 초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 **n대의 자동차**는 전진 또는 멈출 수 있다.
- 각 자동차에 **이름을 부여**할 수 있다.
- 전진하는 자동차를 출력할 때 **자동차 이름을 같이 출력**한다.
- **자동차 이름은 쉼표(,)** 를 기준으로 구분하며, **이름은 5자 이하**만 가능하다.
- 사용자는 **이동 횟수**를 입력할 수 있어야 한다.
- 전진 조건은 **0에서 9 사이의 무작위 값**을 구한 후,  
  **무작위 값이 4 이상일 경우 전진**한다.
- 자동차 경주가 완료되면 **우승자(들)** 을 알려준다.
    - **우승자는 한 명 이상**일 수 있다.
    - 여러 명일 경우 **쉼표(,)** 로 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고,  
  **애플리케이션은 종료**되어야 한다.

---

## 💬 입출력 요구 사항

### 📥 입력

경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
``` 
pobi,woni,jun
```
시도할 횟수
``` 
5
```

### 📤 출력

차수별 실행 결과
```
pobi : –
woni : ––
jun : —
```

단독 우승자 안내 문구
```
최종 우승자 : pobi
```

공동 우승자 안내 문구
```
최종 우승자 : pobi, jun
```

---

## 🧩 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : –
woni : -
jun : –

pobi : —
woni : –
jun : —

pobi : ––
woni : —
jun : ––

pobi : —–
woni : ––
jun : —–

최종 우승자 : pobi, jun
```

## 🧑‍💻 프로그래밍 요구 사항 1

- **JDK 21 버전**에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 **파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.**
- 자바 코드 컨벤션을 지키며 프로그래밍한다.
    - 기본적으로 [**Java Style Guide**](https://google.github.io/styleguide/javaguide.html)를 원칙으로 한다.

---

## 🧠 프로그래밍 요구 사항 2

- **indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.**
    - 최대 depth는 **2까지만 허용**된다.
    - 예: `while`문 안에 `if`문이 있다면 들여쓰기는 2이다.
    - 💡 힌트: indent depth를 줄이는 좋은 방법은 **함수(또는 메서드)를 분리**하는 것이다.
- **3항 연산자를 사용하지 않는다.**
- **함수(또는 메서드)는 한 가지 일만 하도록 작게 작성한다.**
- **JUnit 5와 AssertJ**를 이용해 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고한다.
    - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
    - [AssertJ User Guide](https://assertj.github.io/doc/)
    - [AssertJ Exception Assertions](https://assertj.github.io/doc/#assertj-core-exception-assertions)
    - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

---

## 📚 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 **Randoms** 및 **Console API**를 사용하여 구현해야 한다.
    - Random 값 추출은 ```camp.nextstep.edu.missionutils.Randoms```의 ```pickNumberInRange()```를 활용한다.
    - 사용자가 입력하는 값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```을 활용한다.

### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환
```
Randoms.pickNumberInRange(0, 9);
```

---

# 🚗 과제 내용

## 📋 구현 기능 목록
- [ ] n번 동안 x대의 자동차가 전진하고 멈추는 기능
- [x] 각 자동차에 이름 부여하는 기능
- [ ] 자동차가 쉼표 기준으로 구분하는 기능 / 구분된 이름의 개수를 셀 수 있는 기능 / (에) 자동차 이름이 쉼표를 기준으로 5자 이상이 되면 에러가 나게 하는 기능
- [x] 입력을 받는 기능
- [ ] 0에서 9사이에서 무작위 값을 구하는 기능
- [ ] 무작위 값이 4미만일 경우 전진하지 못하고, 4이상일 경우 전진하게 하는 기능
- [ ] 경주 게임에서 등수를 알 수 있는 기능 → (조건 : 누가 우승을 했는지 알 수 있다 / 우승자는 1명 이상일 수 있음)
- [ ] n명의 우승자에게 쉼표로 구분 할 수 있는 기능
- [x] 출력하는 기능 (조건 : 차수별 실행 결과 / 단독 우승자 안내 or 공동 우승자 안내 + 출력시 이름 같이 출력하는 기능)
