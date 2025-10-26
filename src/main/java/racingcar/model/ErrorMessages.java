package racingcar.model;

public final class ErrorMessages {
    private ErrorMessages() {}

    // 입력_InputView
    public static final String NULL_OR_EMPTY_INPUT = "입력값이 비어있습니다.";
    public static final String INVALID_DELIMITER_FORMAT = "입력값은 쉼표(,)로 구분해야 합니다.";
    public static final String INVALID_NAME_FORMAT = "자동차 이름에는 숫자나 특수문자를 포함할 수 없습니다.";
    public static final String NOT_A_NUMBER = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String ATTEMPT_COUNT_NOT_POSITIVE = "[ERROR] 시도 횟수는 1 이상이어야 합니다.";

    // model _ Car
    public static final String NAME_TOO_LONG = "자동차 이름은 5자 이하만 가능합니다.";
}
