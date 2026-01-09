package racingcar;

import racingcar.contorller.RacingController;
import racingcar.model.Car;
import racingcar.model.Move;
import racingcar.model.Service;
import racingcar.model.Winner;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        System.out.print("잘 돌아가는 중");

        Input input = new Input();
        Output output = new Output();

        Car car = new Car();
        Move move = new Move();
        Winner winner = new Winner();

        Service service = new Service(move, car, winner);

        RacingController controller = new RacingController(input, output, service);

        controller.start();
    }
}
