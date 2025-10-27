package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<String> carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        carNameValidate(input);

        List<String> carName = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return carName;
    }

    public void carNameValidate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.NULL_OR_EMPTY_INPUT);
        }

        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DELIMITER_FORMAT);
        }

        if (!input.matches("^[a-zA-Z가-힣,\\s]+$")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME_FORMAT);
        }
    }

    public int countNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine();

        countNumValidate(input);

        int countNum = Integer.parseInt(input.trim());

        return countNum;
    }

    public void countNumValidate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_OR_EMPTY_INPUT);
        }

        String s = input.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.NULL_OR_EMPTY_INPUT);
        }

        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.NOT_A_NUMBER);
        }

        int num = Integer.parseInt(s);
        if (num <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ATTEMPT_COUNT_NOT_POSITIVE);
        }
    }

}
