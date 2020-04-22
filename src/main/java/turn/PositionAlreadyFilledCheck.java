package turn;

import board.Marker;
import board.exception.PositionAlreadyFilledException;
import exception.WrongPlayException;
import position.Position;

import java.util.HashSet;
import java.util.Set;

public class PositionAlreadyFilledCheck implements PlayerTurnCheck {

    Set<Position> alreadyFilledPositions = new HashSet<>();

    @Override
    public void forThe(Marker marker, Position position) throws WrongPlayException {

        if (alreadyFilledPositions.contains(position)){
            throw new PositionAlreadyFilledException();
        }
        alreadyFilledPositions.add(position);
    }
}
