package baseball.service;

import baseball.constant.GameConst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.GameConst.RANDOM_NUMBER_SIZE;

public class ProcessorService {

    public List<Integer> inputNumberParseToIntegerList(String input) {
        isValidNumber(input);
        List<Integer> numbers = convertToIntegerList(input);
        isThreeNumberSize(numbers);
        isNotDuplicate(numbers);

        return numbers;
    }

    private void isValidNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 세자리의 숫자로 입력해주세요.");
        }
    }

    private List<Integer> convertToIntegerList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private void isThreeNumberSize(List<Integer> numbers) {
        if (numbers.size() != RANDOM_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 세자리의 숫자로 입력해주세요.");
        }
    }

    private void isNotDuplicate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);

        if (noDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 세자리의 숫자로 입력해주세요.");
        }
    }
}
