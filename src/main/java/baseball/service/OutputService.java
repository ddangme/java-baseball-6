package baseball.service;


import static baseball.constant.GameConst.RANDOM_NUMBER_SIZE;

public class OutputService {

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameWinMessage() {
        System.out.println(RANDOM_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
