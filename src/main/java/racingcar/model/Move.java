package racingcar.model;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Move {
    public boolean randomMove() {
        Random random = new Random();

        int dice = random.nextInt(10);

        boolean answer;

        if (dice >= 4) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    public Map<String, Integer> oneRound (List<String> carNameList, Map<String, Integer> resultMap) {
        for (int i = 0; i < carNameList.size(); i++) {
            boolean go = randomMove();
            String car = carNameList.get(i);

            resultMap.put(car, resultMap.getOrDefault(car, 0) + (go ? 1 : 0));
        }
        return resultMap;
    }
}
