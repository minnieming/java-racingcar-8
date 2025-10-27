package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private final String name;
    private int position;

    // 01. 이름 길이 검증
    public Car(String name) {
        String trimmed = name.trim();
        if (trimmed.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.NAME_TOO_LONG);
        }
        this.name = trimmed;
        this.position = 0;
    }

    // 02. 자동차 쉼표로 구분
    public static List<Car> parseCars(String input) {
        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    // 03-1. 랜덤 기반 전진/멈춤
    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        move(number);
    }

    // 03-2. 테스트를 용이하게 하기 위해 분리
    public void move(int number) {
        if (number >= 4) {
            position += 1;
        }
    }

    //
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
