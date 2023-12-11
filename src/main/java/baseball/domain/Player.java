package baseball.domain;

import java.util.List;

public class Player {
    private List<Integer> playerNumbers;
    private int ballCount = 0;
    private int StrikeCount = 0;

    public Player(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.StrikeCount = strikeCount;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public boolean ballCountIsNotNull() {
        if (ballCount == 0) {
            return false;
        }
        return true;
    }

    public boolean StrikeCountIsNotNull() {
        if (StrikeCount == 0) {
            return false;
        }
        return true;
    }

    public boolean ballAndStrikeCountIsNull() {
        if (ballCount == 0 && StrikeCount == 0) {
            return true;
        }

        return false;
    }

    public String ballCountToString() {
        return ballCount + "볼";
    }

    public String strikeCountToString() {
        return StrikeCount + "스트라이크";
    }
}

