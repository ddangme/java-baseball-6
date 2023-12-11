package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> randomNumbers = new ArrayList<>();

    public Game(List<Integer> randoms) {
        this.randomNumbers = randoms;
    }

    public int getStrikeCount(List<Integer> userNumbers) {
        int count = 0;

        for (int i = 0; i < randomNumbers.size(); i++) {
            if (userNumbers.get(i).equals(randomNumbers.get(i))) {
                count++;
            }
        }

        return count;
    }

    public int getBallCount(List<Integer> userNumbers) {
        int count = 0;

        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.contains(userNumbers.get(i)) && randomNumbers.indexOf(userNumbers.get(i)) != i) {
                count++;
            }
        }

        return count;
    }
}
