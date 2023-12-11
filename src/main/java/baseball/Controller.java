package baseball;

import baseball.constants.StatusValue;
import baseball.domain.Player;
import baseball.service.*;
import baseball.util.RandomUtil;

import java.util.List;

public class Controller {

    OutputService outputService = new OutputService();
    InputService inputService = new InputService();
    GameService gameService;
    ValidationService validationService = new ValidationService();
    ParseService parseService = new ParseService();

    public void run() {
        outputService.printGameStartMessage();
        while (newGame());
    }

    public boolean newGame() {
        gameService = new GameService();
        setComputerNumber();
        while (calculateResult());

        outputService.printGameEndMessage();
        return getContinue();
    }

    public void setComputerNumber() {
        List<Integer> randoms = RandomUtil.pickRandomThreeNumber();
        gameService.setLotto(randoms);
        System.out.println(randoms);
    }

    public boolean calculateResult() {
        String inputNumbers = inputService.getThreeNumbers();
        List<Integer> numbers = parseService.toIntegerList(inputNumbers);
        validationService.validatePlayerNumbers(numbers);
        Player player = new Player(numbers);
        gameService.calculateResult(player);
        outputService.printBallAndStrikeCountMessage(player);

        return player.continueGame();
    }

    private boolean getContinue() {
        String inputNumber = inputService.getNumber();
        StatusValue.validate(inputNumber);
        return StatusValue.getStatus(inputNumber);
    }

}
