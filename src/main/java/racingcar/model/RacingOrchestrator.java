package racingcar.model;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingOrchestrator {

    private final Race race;
    private final OutputView outputView;

    public RacingOrchestrator(Race race, OutputView outputView) {
        this.race = race;
        this.outputView = outputView;
    }

    public void run(int rounds) {
        List<List<Car>> snapshots = new ArrayList<>();

        for (int r = 0; r < rounds; r++) {
            // 1) 라운드 진행
            for (Car car : race.getCars()) {
                int n = race.getRandomNumber();
                if (race.canMove(n)) {
                    car.move(n); // 규칙: 4 이상이면 +1
                }
            }
            // 2) 스냅샷 저장(출력용: 과거 라운드 상태 보존)
            List<Car> roundCopy = new ArrayList<>();
            for (Car car : race.getCars()) {
                roundCopy.add(copyOf(car));
            }
            snapshots.add(roundCopy);
        }

        String winnersCsv = race.findWinner();
        outputView.printAll(snapshots, winnersCsv);
    }

    private Car copyOf(Car original) {
        Car copied = new Car(original.getName());
        int steps = original.getPosition();
        for (int i = 0; i < steps; i++) {
            copied.move(4);
        }
        return copied;
    }
}