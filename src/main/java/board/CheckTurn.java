package board;

import exception.WrongMoveException;

public interface CheckTurn {
    void forThe(Marker marker) throws WrongMoveException;
}
