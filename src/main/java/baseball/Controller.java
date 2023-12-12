package baseball;

import baseball.domain.Game;
import baseball.domain.Hint;
import baseball.service.GameService;
import baseball.service.InputService;
import baseball.service.OutputService;
import baseball.service.ProcessorService;

import java.util.List;

public class Controller {

    private final ProcessorService processorService = new ProcessorService();
    private final OutputService outputService = new OutputService();
    private final InputService inputService = new InputService();
    private final GameService gameService = new GameService();

    public void run() {
        outputService.printGameStartMessage();
        Game newGame = gameService.createNewGame();
        playGame(newGame);

    }

    private void playGame(Game game) {
        boolean status = true;
        while (status) {
            List<Integer> userNumbers = getUserNumbers();
            Hint hint = gameService.getHint(userNumbers);
            outputService.printHintMessage(hint);

            status = hint.isLose();
        }
    }

    private List<Integer> getUserNumbers() {
        List<Integer> userNumbers = null;

        while (userNumbers == null) {
            try {
                String inputUserNumber = inputService.getUserNumber();
                userNumbers = processorService.inputNumberParseToIntegerList(inputUserNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return userNumbers;
    }

}
