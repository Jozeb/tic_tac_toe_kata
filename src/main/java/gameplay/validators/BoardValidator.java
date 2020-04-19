package gameplay.validators;

import board.Board;
import gameplay.GameState;

public interface BoardValidator {
    boolean isGameFinished(Board board);
    GameState getGameState();
}
