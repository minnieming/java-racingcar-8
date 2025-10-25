package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private final InputView inputView = new InputView();

    // A. 경주할 자동차 이름
    @Test
    void 정상값_이름_입력() {
        assertThatCode(() -> inputView.carNameValidate("pobi, woni"))
                .doesNotThrowAnyException();
        assertThatCode(() -> inputView.carNameValidate("포비,  워니"))
                .doesNotThrowAnyException();
    }

    @Test
    void 쉼표_구분자_오류() {
        assertThatThrownBy(() -> inputView.carNameValidate("pobi")) // 하나만
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.carNameValidate("pobi woni")) // 공백 구분
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_특수문자_오류() {
        assertThatThrownBy(() -> inputView.carNameValidate("pobi1,woni"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.carNameValidate("pobi,wo#ni"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // B. 시도할 횟수
    @Test
    void 정상값_시도_횟수() {
        assertThatCode(() -> inputView.countNumValidate("1"))
                .doesNotThrowAnyException();
        assertThatCode(() -> inputView.countNumValidate("  7  "))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자가_아닌_값() {
        assertThatThrownBy(() -> inputView.countNumValidate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.countNumValidate("12a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수일떼() {
        assertThatThrownBy(() -> inputView.countNumValidate("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.countNumValidate("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 공통 에러
    @Test
    void null_빈문자열() {
        assertThatThrownBy(() -> inputView.carNameValidate(null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.carNameValidate(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.carNameValidate("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}