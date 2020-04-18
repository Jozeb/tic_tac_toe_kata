import board.Board;
import turn.CheckFirstTurn;
import turn.CheckTurn;
import board.Marker;
import board.Position;
import turn.CheckTurnSequence;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;
import turn.TurnCheckers;

import java.util.Arrays;
import java.util.List;

public class TicTacGame {

    Board board = new Board();
    TurnCheckers turnCheckers = new TurnCheckers();

    public void play(Marker marker, Position position) throws WrongMoveException {
        turnCheckers.runAllFor(marker);

        if (board.contains(position)) {
            throw new PositionAlreadyFilledException();
        }
        board.add(position, marker);
    }

    public boolean is(Marker cross, Position position) {
        return true;
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
