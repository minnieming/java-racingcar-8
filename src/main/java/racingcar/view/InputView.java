package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    // A. 경주할 자동차 이름
    public List<String> carName() {
        // 01. 사용자에게 입력 받을 문장
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 02. 입력창 열기
        String input = Console.readLine();

        // 03. 예외처리 하기
        carNameValidate(input);

        // 04. 값을 반환값에 맞추기
        List<String> carName = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        // 04. 결과값 반환하기
        return carName;
    }

    public void carNameValidate(String input) {
        // 01. null 또는 빈 문자열일 때
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.NULL_OR_EMPTY_INPUT);
        }

        // 02. 쉼표만 입력하거나 구분자 오류
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DELIMITER_FORMAT);
        }

        // 03. 이름 안에 숫자, 특수문자 등 예상치 못한 입력이 들어왔을 때
        if (!input.matches("^[a-zA-Z가-힣,\\s]+$")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME_FORMAT);
        }
    }

    // B. 시도할 횟수
    public int countNum() {
        // 01. 사용자에게 입력 받을 문장
        System.out.println("시도할 횟수는 몇 회인가요?");

        // 02. 입력창 열기
        String input = Console.readLine();

        // 03. 예외처리 하기
        countNumValidate(input);

        // 04. 값을 반환값에 맞추기
        int countNum = Integer.parseInt(input.trim());

        // 04. 결과값 반환하기
        return countNum;
    }

    public void countNumValidate(String input) {
        // 01. null 또는 빈 문자열일 때
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_OR_EMPTY_INPUT);
        }

        String s = input.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.NULL_OR_EMPTY_INPUT);
        }

        // 02. 숫자가 아닐 때
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.NOT_A_NUMBER);
        }

        // 03. 0 이하일 때
        int num = Integer.parseInt(s);
        if (num <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ATTEMPT_COUNT_NOT_POSITIVE);
        }
    }

}
