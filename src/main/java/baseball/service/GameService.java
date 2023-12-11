package baseball.service;

import baseball.domain.Game;
import baseball.domain.Player;

import java.util.List;

public class GameService {

    private Game game;

    public void setLotto(List<Integer> numbers) {
        this.game = new Game(numbers);
    }

    public void calculateResult(Player player) {
        calculateBallCount(player);
        calculateStrikeCount(player);
    }

    private void calculateBallCount(Player player) {
        int ballCount = game.getBallCount(player.getPlayerNumbers());
        player.setBallCount(ballCount);
    }

    private void calculateStrikeCount(Player player) {
        int strikeCount = game.getStrikeCount(player.getPlayerNumbers());
        player.setStrikeCount(strikeCount);
    }
}
