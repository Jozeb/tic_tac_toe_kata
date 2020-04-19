package turn;

import board.Marker;
import exception.WrongPlayException;

public interface PlayerTurnCheck {
    void forThe(Marker marker) throws WrongPlayException;
}
