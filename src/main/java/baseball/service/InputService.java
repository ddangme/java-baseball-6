package baseball.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public String getThreeNumbers() {
        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
    }
}
