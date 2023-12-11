package baseball;

import baseball.domain.Player;
import baseball.service.*;
import baseball.util.RandomUtil;

import java.util.List;

public class Controller {

    OutputService outputService = new OutputService();
    InputService inputService = new InputService();
    GameService gameService = new GameService();
    ValidationService validationService = new ValidationService();
    ParseService parseService = new ParseService();

    public void run() {
        outputService.printGameStartMessage();
        setComputerNumber();
        Player player = getPlayer();
        showGameResult(player);
    }

    public void setComputerNumber() {
        List<Integer> randoms = RandomUtil.pickRandomThreeNumber();
        gameService.setLotto(randoms);
        System.out.println(randoms);
    }

    public Player getPlayer() {
        String inputNumbers = inputService.getThreeNumbers();
        List<Integer> numbers = parseService.toIntegerList(inputNumbers);
        validationService.validationThreeNumbers(numbers);
        return new Player(numbers);
    }

    public void showGameResult(Player player) {
        gameService.calculateResult(player);
        outputService.printBallAndStrikeCountMessage(player);
    }
}
