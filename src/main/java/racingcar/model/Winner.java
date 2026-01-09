package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Winner {
    public List<String> racingWinner(Map<String, Integer> totalRoundResult) {
        int max = 0;

        for (int count : totalRoundResult.values()) {
            if (count > max) {
                max = count;
            }
        }

        List<String> winnerList = new ArrayList<>();

        for (Map.Entry<String, Integer> member : totalRoundResult.entrySet()) {
            if (max == member.getValue()) {
                winnerList.add(member.getKey());
            }
        }

        return winnerList;
    }
}
