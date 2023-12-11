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
            System.out.println(player.strikeCountToString());
        }
        if (player.ballAndStrikeCountIsNull()) {
            System.out.println("낫싱");
        }
    }
}
