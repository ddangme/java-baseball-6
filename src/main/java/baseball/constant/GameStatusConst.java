package baseball.constant;

import java.util.Arrays;

public enum GameStatusConst {
    GAME_CONTINUE(1),
    GAME_STOP(2);

    private int status;

    GameStatusConst(int status) {
        this.status = status;
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


}
