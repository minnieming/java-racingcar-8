package racingcar.model;

public class Car {
    private final String name;
    private int position;

    // 01. 이름 길이 검증 (입력값 null/빈 문자열 검증은 InputView에서 처리)
    public Car(String name) {
        String trimmed = name.trim();  // InputView에서 이미 공백, null 방지됨
        if (trimmed.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.NAME_TOO_LONG);
        }
        this.name = trimmed;
        this.position = 0;
    }

    //
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, position));
    }
}
