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
            List<String> carNames = inputView.carName();
            int rounds = inputView.countNum();

            List<Car> cars = carNames.stream()
                    .map(Car::new) // 이름 길이 5자 초과 시 여기서 IllegalArgumentException 발생
                    .collect(Collectors.toList());

            Race race = new Race(cars);
            RacingOrchestrator orchestrator = new RacingOrchestrator(race, outputView);

            orchestrator.run(rounds);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}