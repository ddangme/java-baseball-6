package baseball.service;

import baseball.domain.Player;

public class OutputService {

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printBallAndStrikeCountMessage(Player player) {

        if (player.ballCountIsNotNull()) {
            System.out.print(player.ballCountToString() + " ");
        }
        if (player.StrikeCountIsNotNull()) {
            System.out.print(player.strikeCountToString());
        }
        if (player.ballAndStrikeCountIsNull()) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
