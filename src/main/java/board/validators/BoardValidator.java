package board.validators;

import board.Board;
import gameplay.GameState;

import java.util.Optional;

public interface BoardValidator {
    public Optional<GameState> getGameState(Board board);
}
