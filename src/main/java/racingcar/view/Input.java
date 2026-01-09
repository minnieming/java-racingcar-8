package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.ErrorMessages;

public class Input {
    // 시도할 횟수
    public int tries(){
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine(); // 처음에는 String으로 만들어야 한다.

        int tries = validateTries(input);

        return tries;
    }

    public int validateTries(String input) {
        if (input == null || input.trim().isEmpty()) { // 1. 빈값인지 확인하기
            throw new IllegalArgumentException(ErrorMessages.INPUT_NULL_EMPTY);
        }

        // 2. 숫자(양수)인지 확인하기
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOT_NUM);
        }

        int tries = Integer.parseInt(input);

        // 3. 0이 아닌 수로 보내기 위해서 0을 제외하기
        if (tries <= 0) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_MORE_0);
        }

        return tries;
    }

    // 자동차 이름
    public String carName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String carName = validateCarName(input);

        return carName;
    }

    public String validateCarName(String rawInput) {
        String input = rawInput.replaceAll("\\s+", "");

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NULL_EMPTY);
        }

        // 구분자가 , 만 있는지 확인하기, 알파벳으로 되어 있는지 확인하기
        if (!input.trim().matches("[a-zA-Z가-힣,]+")) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_ALPHABET_COMMA);
        }

        return input;
    }
}
