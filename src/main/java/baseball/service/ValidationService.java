package baseball.service;

import baseball.constants.GameValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationService {

    public void validateThreeNumbers(List<Integer> numbers) {
        checkSize(numbers);
        checkRange(numbers);
        checkDuplicate(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != GameValue.LOTTO_SIZE) {
            throw new IllegalArgumentException("3자리의 숫자로 입력해주세요.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < GameValue.START_NUMBER || number > GameValue.END_NUMBER) {
                throw new IllegalArgumentException("1에서 9사이의 숫자로 입력해주세요.");
            }
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> deduplicateNumbers = new HashSet<>(numbers);

        if (deduplicateNumbers.size() != GameValue.LOTTO_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }



}
