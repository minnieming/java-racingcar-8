package racingcar.contorller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.Service;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {

    private final Input input;
    private final Output output;
    private final Service service;

    public RacingController(Input input, Output output, Service service) {
        this.input = input;
        this.output = output;
        this.service = service;
    }

    public void start(){
        String carName = input.carName();
        int tries = input.tries();
        output.start();

        Map<String, Integer> resultMap = new LinkedHashMap<>();

        for (int i = 0; i < tries; i++) {
            resultMap = service.racingGameResult(tries, carName, resultMap);
            output.raceResult(resultMap);
        }

//        Map<String, Integer> raceWin = new LinkedHashMap<>();

        List<String> winnerList = service.racingWinner(tries, carName, resultMap);
        output.winnerResult(winnerList);
    }
}
