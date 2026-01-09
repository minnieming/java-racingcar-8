package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.model.ErrorMessages;

class InputTest {

    private final Input input = new Input();

    // 시도할 횟수
    @Test
    void 정상_시도횟수() {
        int result = input.validateTries("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void null인_경우() {
        assertThatThrownBy(()-> input.validateTries(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INPUT_NULL_EMPTY);
    }
    @Test
    void 빈값인_경우() {
        assertThatThrownBy(()-> input.validateTries(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INPUT_NULL_EMPTY);
    }

    @Test
    void 숫자가_아닌_경우() {
        assertThatThrownBy(()-> input.validateTries("ㅎ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INPUT_NOT_NUM);
    }

    @Test
    void 구분자인_경우() {
        assertThatThrownBy(()-> input.validateTries("/"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INPUT_NOT_NUM);
    }

    @Test
    void 음수_경우() {
        assertThatThrownBy(()-> input.validateTries("-7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INPUT_NOT_NUM);
    }

    @Test
    void 제로인_경우() {
        assertThatThrownBy(()-> input.validateTries("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INPUT_MORE_0);
    }

    // 자동차 이름
    @Test
    void 정상_자동차_한글이름() {
        String result = input.validateCarName("채형원");
        assertThat(result).isEqualTo("채형원");
    }

    @Test
    void 정상_자동차_영어이름() {
        String result = input.validateCarName("bebe");
        assertThat(result).isEqualTo("bebe");
    }

    @Test
    void 정상_자동차이름_다중() {
        String result = input.validateCarName("채형원, bebe");
        assertThat(result).isEqualTo("채형원,bebe");
    }

    // 아직 예외처리에 대해서는 안했음
}