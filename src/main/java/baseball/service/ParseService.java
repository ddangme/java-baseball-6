package baseball.service;

import baseball.constants.StatusValue;

import java.util.ArrayList;
import java.util.List;

public class ParseService {

    public List<Integer> toIntegerList(String input) {
        List<Integer> userNumbers = new ArrayList<>();

        String[] numbers = input.split("");
        for (String number : numbers) {
            userNumbers.add(toInteger(number));
        }

        return userNumbers;
    }

    private Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            new IllegalArgumentException("숫자로 입력해주세요.");
        }

        return null;
    }
}
