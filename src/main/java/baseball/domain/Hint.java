package baseball.domain;

import static baseball.constant.GameConst.RANDOM_NUMBER_SIZE;

public class Hint {
    private int strike;
    private int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isLose() {
        return strike != RANDOM_NUMBER_SIZE;
    }

    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }

        StringBuilder resultBuilder = new StringBuilder();

        if (ball != 0) {
            resultBuilder.append(ball).append("볼 ");
        }
        if (strike != 0) {
            resultBuilder.append(strike).append("스트라이크");
        }

        return resultBuilder.toString();
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }
}
