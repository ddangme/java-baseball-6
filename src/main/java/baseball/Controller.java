package baseball;

import baseball.constant.GameStatusConst;
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

        boolean gameContinue = true;

        while (gameContinue) {
            Game newGame = gameService.createNewGame();
            playGame(newGame);
            gameContinue = getGameStatus();
        }
    }

    private void playGame(Game game) {
        boolean status = true;

        while (status) {
            List<Integer> userNumbers = getUserNumbers();
            Hint hint = gameService.getHint(userNumbers);
            outputService.printHintMessage(hint);

            status = hint.isLose();
        }

        outputService.printGameWinMessage();
    }

    private List<Integer> getUserNumbers() {
        List<Integer> userNumbers = null;

        while (userNumbers == null) {
            try {
                String inputUserNumber = inputService.getUserNumber();
                userNumbers = processorService.stringParseToIntegerList(inputUserNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return userNumbers;
    }

    private boolean getGameStatus() {
        while (true) {
            try {
                String inputGameStatus = inputService.getGameStatus();
                GameStatusConst gameStatusConst = processorService.stringParseToGameStatus(inputGameStatus);

                return gameStatusConst.gameContinue();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}