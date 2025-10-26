package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    // 01. 생성자 테스트
    @Test
    void 정상값_이름_5자_이하() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 이름_6자_이상() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NAME_TOO_LONG);
    }

    // 02. parseCars() 테스트
    @Test
    void 정상값_쉼표기준_자동차_목록() {
        List<Car> cars = Car.parseCars("pobi, woni, java");
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("java");
    }

    @Test
    void 공백_포함() {
        List<Car> cars = Car.parseCars("  pobi  ,   woni ");
        assertThat(cars).hasSize(2);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
    }

    // 03-1. move(int): 숫자가 4 이상이면 전진, 미만이면 멈춤
    @Test
    void 정상값_입력값_4_이상_전진() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 입력값_3_이하() {
        Car car = new Car("woni");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    // 03-2. move(): 랜덤 기반 호출 — 실제 실행 시 예외 없이 동작하는지만 확인
    @Test
    void 정상값_랜덤기반_move_호출시_동작() {
        Car car = new Car("pobi");
        assertThatCode(car::move)
                .doesNotThrowAnyException();
    }
}