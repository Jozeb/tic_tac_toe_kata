package gameplay;

import board.Board;
import win.WinValidator;

import java.util.Optional;

import static gameplay.GameState.IN_PROGRESS;

public class GameOutcome {

    GameState gameState = IN_PROGRESS;
    WinValidator winValidator = new WinValidator();

    public void updateBasedOn(Board board) {
        Optional<GameState> outcome = winValidator.isWin(board);
        if (outcome.isPresent()) {
            this.gameState = outcome.get();
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}
