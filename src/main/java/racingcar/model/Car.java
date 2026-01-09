package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    public List<String> carName(String wholeName) {
        List<String> carNameList = new ArrayList<>(Arrays.asList(wholeName.split(",")));

        // 리스트로 앞으로 한칸씩 미뤄지니까 뒤에서부터 시작하는게 좋다!
        // For문의 조건식이 다 맞아야 동작을 한다
        for (int i = carNameList.size() -1; i > 0; i--) {
            if (carNameList.get(i).length() > 5) {
                carNameList.remove(i);
                throw new IllegalArgumentException(ErrorMessages.INPUT_MORE_0);
            }
        }

        return carNameList;
    }
}
