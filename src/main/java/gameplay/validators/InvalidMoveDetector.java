package gameplay.validators;

import exception.GameAlreadyEndedException;
import gameplay.GameState;

public class InvalidMoveDetector {
    public void detect(GameState gameState) throws GameAlreadyEndedException {
        if (gameState != GameState.IN_PROGRESS) {
            throw new GameAlreadyEndedException();
        }

    }
}
