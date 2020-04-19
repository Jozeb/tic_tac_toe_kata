package turn;

import board.Marker;
import exception.WrongMoveException;

public interface PlayerTurnCheck {
    void forThe(Marker marker) throws WrongMoveException;
}
