package baseball.constant;

import java.util.Arrays;

public enum GameStatusConst {
    GAME_CONTINUE(1, true),
    GAME_STOP(2, false);

    private int status;
    private boolean run;

    GameStatusConst(int status, boolean run) {
        this.status = status;
        this.run = run;
    }

    public static GameStatusConst getGameStatus(int status) {
        return Arrays.stream(values())
                .filter(value -> value.status == status)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 1혹은 2를 입력해주세요."));
    }

    public int getStatus() {
        return status;
    }

    public boolean gameContinue() {
        return run;
    }


}
