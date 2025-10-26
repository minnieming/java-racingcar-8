package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void printAll(List<List<Car>> snapshots, String winnersCsv) {
        System.out.println();
        System.out.println("실행 결과");
        for (List<Car> round : snapshots) {
            for (Car car : round) {
                String dashes = "-".repeat(Math.max(0, car.getPosition()));
                System.out.println(car.getName() + " : " + dashes);
            }
            System.out.println();
        }
        System.out.println("최종 우승자 : " + winnersCsv);
    }
}