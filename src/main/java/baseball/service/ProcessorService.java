package baseball.service;

import baseball.constant.GameStatusConst;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.GameConst.RANDOM_NUMBER_SIZE;

public class ProcessorService {

    public List<Integer> stringParseToIntegerList(String value) {
        isValidNumber(value);
        List<Integer> numbers = convertToIntegerList(value);
        isThreeNumberSize(numbers);
        isNotDuplicate(numbers);
        checkRange(numbers);

        return numbers;
    }

    private void isValidNumber(String value) {
        try {
            int input = Integer.parseInt(value);
            if (input < 0) {
                throw new IllegalArgumentException("[ERROR] 세자리의 숫자로 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 세자리의 숫자로 입력해주세요.");
        }
    }

    private List<Integer> convertToIntegerList(String value) {
        return value.chars()
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

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 1에서 9사이의 수로 입력해주세요.");
            }
        }
    }

    public GameStatusConst stringParseToGameStatus(String value) {
        try {
            int number = Integer.parseInt(value);

            return GameStatusConst.getGameStatus(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1 혹은 2를 입력해 주세요.");
        }
    }


}
