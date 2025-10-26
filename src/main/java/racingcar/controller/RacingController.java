package racingcar.controller;

import racingcar.model.RacingOrchestrator;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            // 01. 사용자 입력
            List<String> carNames = inputView.carName(); // 쉼표(,)로 구분된 이름 입력
            int rounds = inputView.countNum();           // 시도할 횟수 입력

            // 02. 자동차 리스트 생성
            List<Car> cars = carNames.stream()
                    .map(Car::new) // 이름 길이 5자 초과 시 여기서 IllegalArgumentException 발생
                    .collect(Collectors.toList());

            // 03. 경주 규칙/로직 객체 생성
            Race race = new Race(cars);
            RacingOrchestrator orchestrator = new RacingOrchestrator(race, outputView);

            // 04. 전체 게임 실행
            orchestrator.run(rounds);

        } catch (IllegalArgumentException e) {
            // 메시지 출력 후 반드시 재던지기 → 테스트에서 예외 감지 가능
            System.out.println(e.getMessage());
            throw e;
        }
    }
}