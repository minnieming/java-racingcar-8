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

}