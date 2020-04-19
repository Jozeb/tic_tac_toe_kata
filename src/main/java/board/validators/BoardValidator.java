package board.validators;

import board.Board;
import gameplay.GameState;

import java.util.Optional;

public interface BoardValidator {
    boolean isGameFinished(Board board);
    GameState getGameState();
}
