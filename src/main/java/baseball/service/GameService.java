package baseball.service;

import baseball.domain.Game;
import baseball.domain.Hint;

import java.util.List;

public class GameService {
    private Game game;

    public GameService() { }

    public Game createNewGame() {
        this.game = new Game();
        return this.game;
    }

    public Hint getHint(List<Integer> userNumbers) {
        int strikeCount = game.getStrikeCount(userNumbers);
        int ballCount = game.getBallCount(userNumbers);

        return new Hint(strikeCount, ballCount);
    }


}
