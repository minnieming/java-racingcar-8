package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    // 1) 0~9 랜덤
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 2) 4 이상이면 전진
    public boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }

    // 3) position 내림차순 정렬 결과 반환
    public List<Car> calculateRank() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getPosition).reversed())
                .collect(Collectors.toList());
    }

    //
    public List<Car> getCars() {
        return cars;
    }
}
