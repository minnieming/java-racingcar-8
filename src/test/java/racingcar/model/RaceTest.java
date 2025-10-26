package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    // 테스트 편의: 참가자 생성
    private List<Car> 참가자(String 입력) {
        return Car.parseCars(입력);
    }

    // 1) 0~9 무작위
    @Test
    void 정상값_0에서_9_랜덤() {
        Race race = new Race(참가자("pobi, woni"));
        for (int i = 0; i < 200; i++) {
            int n = race.getRandomNumber();
            assertThat(n).isBetween(0, 9);
        }
    }

    // 2) 4 이상 전진
    @Test
    void 정상값_4이상_전진() {
        Race race = new Race(참가자("pobi, woni"));
        assertThat(race.canMove(4)).isTrue();
        assertThat(race.canMove(9)).isTrue();
    }

    @Test
    void 정상값_3이하_전진불가() {
        Race race = new Race(참가자("pobi, woni"));
        assertThat(race.canMove(3)).isFalse();
        assertThat(race.canMove(0)).isFalse();
    }

    @Test
    void 정상값_canMove_경계값_검증() {
        Race race = new Race(참가자("pobi"));
        assertThat(race.canMove(3)).isFalse(); // 임계 바로 아래
        assertThat(race.canMove(4)).isTrue();  // 임계 바로 위
    }

}