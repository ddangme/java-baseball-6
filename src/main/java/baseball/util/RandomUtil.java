package baseball.util;

import baseball.constants.BallRange;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public static List<Integer> pickRandomThreeNumber() {
        List<Integer> randoms = new ArrayList<>();

        while (randoms.size() < BallRange.LOTTO_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BallRange.START_NUMBER, BallRange.END_NUMBER);

            if (!randoms.contains(randomNumber)) {
                randoms.add(randomNumber);
            }
        }

        return randoms;
    }

}
