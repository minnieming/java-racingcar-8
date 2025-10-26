package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    // 1) 0~9 랜덤
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    //
    public List<Car> getCars() {
        return cars;
    }
}
