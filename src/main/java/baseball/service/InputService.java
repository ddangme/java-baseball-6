package baseball.service;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.GameStatusConst.GAME_CONTINUE;
import static baseball.constant.GameStatusConst.GAME_STOP;

public class InputService {

    public String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String getGameStatus() {
        System.out.println("게임을 새로 시작하려면 " +
                GAME_CONTINUE.getStatus() +
                ", 종료하려면 " +
                GAME_STOP.getStatus() + "를 입력하세요.");
        return Console.readLine();
    }
}
