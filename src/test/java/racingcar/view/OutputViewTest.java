package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        outputView = new OutputView();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 정상값_전체출력() {

        List<Car> round1 = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        List<Car> round2 = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        round1.get(0).move(4);
        round1.get(2).move(4);
        round2.get(0).move(4);
        round2.get(1).move(4);
        round2.get(2).move(4);

        List<List<Car>> snapshots = List.of(round1, round2);
        String winners = "pobi, jun";

        outputView.printAll(snapshots, winners);

        String result = outContent.toString();
        assertThat(result).contains("실행 결과");
        assertThat(result).contains("pobi : -");
        assertThat(result).contains("jun : -");
        assertThat(result).contains("최종 우승자 : pobi, jun");
    }
}