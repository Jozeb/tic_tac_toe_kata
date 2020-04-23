package gameplay.validators;

import board.Board;
import gameplay.GameState;

import java.util.Arrays;
import java.util.List;

import static gameplay.GameState.IN_PROGRESS;

public class AllBoardValidators {

    List<BoardValidator> boardValidators;

    public AllBoardValidators() {
        boardValidators = Arrays.asList(
                new NoughtWinValidator(),
                new CrossWinValidator(),
                new DrawValidator());
    }

    public GameState validate(Board board) {
        return boardValidators.stream()
                .filter(validator -> validator.isGameFinished(board))
                .findFirst()
                .map(BoardValidator::getGameState)
                .orElse(IN_PROGRESS);
    }
}
