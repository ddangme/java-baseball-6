package baseball.domain;

import baseball.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    private List<Integer> gameNumbers = new ArrayList<>();

    public Game() {
        this.gameNumbers = RandomUtil.getRandomNumbers();
        System.out.println(gameNumbers);
    }

    public int getStrikeCount(List<Integer> userNumbers) {
        return (int) IntStream.range(0, userNumbers.size())
                .filter(i -> userNumbers.get(i).equals(gameNumbers.get(i)))
                .count();
    }

    public int getBallCount(List<Integer> userNumbers) {
        return (int) IntStream.range(0, userNumbers.size())
                .filter(i -> isBall(userNumbers.get(i), i))
                .count();
    }

    private boolean isBall(int number, int index) {
        if (gameNumbers.contains(number)) {
            if (gameNumbers.indexOf(number) != index) {
                return true;
            }
        }

        return false;
    }
}