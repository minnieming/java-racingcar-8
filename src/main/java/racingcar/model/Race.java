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

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<Car> calculateRank() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getPosition).reversed())
                .collect(Collectors.toList());
    }

    public String findWinner() {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", winners);
    }

    public List<Car> getCars() {
        return cars;
    }
}
