package racingcar.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.view.Input;

public class Service {

    private final Move move;
    private final Car car;
    private final Winner winner;

    public Service(Move move, Car car, Winner winner) {
        this.move = move;
        this.car = car;
        this.winner = winner;
    }

    public Map<String, Integer> racingGameResult(int tries, String carName, Map<String, Integer> resultMap) {
        List<String> carNameList = car.carName(carName);

        resultMap = move.oneRound(carNameList, resultMap);

        return resultMap;
    }

    public List<String> racingWinner(int tries, String carName, Map<String, Integer> resultMap) {
        List<String> carNameList = car.carName(carName);

//        resultMap = move.totalRound(tries, carNameList, resultMap);
        List<String> winnerList = winner.racingWinner(resultMap);

        return winnerList;
    }


}
