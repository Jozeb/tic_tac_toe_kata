package board;

import exception.WrongMoveException;

interface CheckTurn {
    void forThe(Marker marker) throws WrongMoveException;
}
