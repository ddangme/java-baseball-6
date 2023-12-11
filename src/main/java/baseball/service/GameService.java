package baseball.service;

import baseball.constants.LottoRange;
import baseball.domain.Lotto;

import java.util.List;

public class LottoService {

    private Lotto lotto;

    public void setLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
    }

    public void calculateLotto(List<Integer> userNumbers) {

    }

    private void getStrikeCount(List<Integer> userNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < LottoRange.LOTTO_SIZE; i++) {
            if (userNumbers.get(i).equals(lotto))
        }
    }

}
