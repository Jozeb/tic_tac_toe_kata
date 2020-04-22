package turn;

import board.Marker;
import exception.WrongPlayException;
import position.Position;

public interface PlayerTurnCheck {
    void forThe(Marker marker, Position position) throws WrongPlayException;
}
