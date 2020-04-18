package turn;

import board.Marker;
import exception.WrongMoveException;

public interface CheckTurn {
    void forThe(Marker marker) throws WrongMoveException;
}
