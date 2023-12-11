package baseball;

import baseball.service.*;
import baseball.util.RandomUtil;

import java.util.List;

public class Controller {

    OutputService outputService = new OutputService();
    InputService inputService = new InputService();
    LottoService lottoService = new LottoService();
    ValidationService validationService = new ValidationService();
    ParseService parseService = new ParseService();

    public void run() {
        outputService.printGameStartMessage();
        setLotto();
    }

    public void setLotto() {
        List<Integer> randoms = RandomUtil.pickRandomThreeNumber();
        lottoService.setLotto(randoms);
    }

    public void setThreeNumbers() {
        String inputNumbers = inputService.getThreeNumbers();
        List<Integer> numbers = parseService.toIntegerList(inputNumbers);
        validationService.validationThreeNumbers(numbers);

    }
}
