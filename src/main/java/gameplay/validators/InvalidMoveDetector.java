package gameplay.validators;

import board.Marker;
import board.exception.PositionAlreadyFilledException;
import exception.WrongPlayException;

import java.util.HashSet;
import java.util.Set;
import position.Position;
import turn.PlayerTurnChecks;

public class InvalidMoveDetector {

    Set<Position> alreadyFilledPositions = new HashSet<>();
    final PlayerTurnChecks playerTurnChecks = new PlayerTurnChecks();

    public void detect(Marker marker, Position position) throws WrongPlayException {
        playerTurnChecks.runFor(marker, position);
    }

    private void positionAlreadyFilled(Position position) throws PositionAlreadyFilledException {

        if (alreadyFilledPositions.contains(position)){
            throw new PositionAlreadyFilledException();
        }
        alreadyFilledPositions.add(position);
    }
}
