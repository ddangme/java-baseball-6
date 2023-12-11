package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> randomNumbers = new ArrayList<>();

    public Lotto(List<Integer> randoms) {
        this.randomNumbers = randoms;
    }

    public int getStrikeCount(List<Integer> userNumbers) {
        return (int) IntStream.range(0, Math.min(userNumbers.size(), randomNumbers.size()))
                .filter(i -> userNumbers.get(i).equals(randomNumbers.get(i)))
                .count();
    }
}
