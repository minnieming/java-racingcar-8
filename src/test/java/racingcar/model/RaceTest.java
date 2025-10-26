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

    // 3) 위치 내림차순 정렬
    @Test
    void 정상값_등수_내림차순() {
        List<Car> cars = 참가자("pobi, woni, java");
        Car pobi = cars.get(0);
        Car woni = cars.get(1);
        Car java = cars.get(2);

        pobi.move(4); pobi.move(7);                // 2칸
        woni.move(9); woni.move(4); woni.move(5);  // 3칸
        java.move(4);                              // 1칸

        Race race = new Race(cars);
        List<Car> rank = race.calculateRank();

        assertThat(rank).extracting(Car::getName)
                .containsExactly("woni", "pobi", "java");
    }

    @Test
    void 정상값_참가자0명_빈리스트() {
        Race race = new Race(List.of());
        assertThat(race.calculateRank()).isEmpty();
    }

    // 4) 최장거리 우승자(복수 가능)
    @Test
    void 정상값_단일우승자_이름만() {
        List<Car> cars = 참가자("pobi, woni, java");
        cars.get(1).move(4); cars.get(1).move(5); cars.get(1).move(9); // woni 3칸
        cars.get(0).move(4); cars.get(0).move(6);                       // pobi 2칸
        cars.get(2).move(4);                                            // java 1칸

        Race race = new Race(cars);
        assertThat(race.findWinner()).isEqualTo("woni");
    }

    @Test
    void 정상값_공동우승자_쉼표로() {
        List<Car> cars = 참가자("pobi, woni, java");
        cars.get(0).move(4); cars.get(0).move(8); cars.get(0).move(5); // pobi 3칸
        cars.get(1).move(4); cars.get(1).move(9); cars.get(1).move(7); // woni 3칸
        cars.get(2).move(4);                                           // java 1칸

        Race race = new Race(cars);
        assertThat(race.findWinner()).isEqualTo("pobi, woni");
    }

    @Test
    void 정상값_공동우승자_3명도_모두_반환한다() {
        List<Car> cars = 참가자("a, b, c");
        cars.get(0).move(4);
        cars.get(1).move(6);
        cars.get(2).move(9); // 모두 1칸 → 3명 공동 우승

        Race race = new Race(cars);
        assertThat(race.findWinner()).isEqualTo("a, b, c");
    }

    @Test
    void 정상값_참가자0명_우승자는_빈문자열() {
        Race race = new Race(List.of());
        assertThat(race.findWinner()).isEmpty();
    }
}