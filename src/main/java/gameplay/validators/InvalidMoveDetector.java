package gameplay.validators;

import board.Marker;
import board.exception.PositionAlreadyFilledException;
import exception.GameAlreadyEndedException;
import exception.WrongPlayException;
import gameplay.GameState;
import java.util.HashSet;
import java.util.Set;
import position.Position;
import turn.PlayerTurnChecks;

public class InvalidMoveDetector {

    Set<Position> alreadyFilledPositions = new HashSet<>();
    final PlayerTurnChecks playerTurnChecks = new PlayerTurnChecks();

    public void detect(Marker marker, Position position, GameState gameState) throws WrongPlayException {
        if (gameState != GameState.IN_PROGRESS) {
            throw new GameAlreadyEndedException();
        }
        playerTurnChecks.runFor(marker);

        positionAlreadyFilled(position);
    }

    private void positionAlreadyFilled(Position position) throws PositionAlreadyFilledException {

        if (alreadyFilledPositions.contains(position)){
            throw new PositionAlreadyFilledException();
        }
        alreadyFilledPositions.add(position);
    }
}
