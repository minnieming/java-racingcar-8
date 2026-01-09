package racingcar.view;

import java.util.List;
import java.util.Map;

public class Output {
    public void start() {
        System.out.println("실행 결과");
    }

    public void raceResult(Map<String, Integer> resultMap) {
        for (Map.Entry<String, Integer> result : resultMap.entrySet()) {
            String name = result.getKey();

            int value = result.getValue();
            String count = "-".repeat(value);

            System.out.println(name + " : " + count);
        }
        System.out.println(" ");
    }

    public void winnerResult(List<String> winnerList) {
        String winner = String.join(", ", winnerList);

        System.out.println("최종 우승자 : " + winner);
    }
}
