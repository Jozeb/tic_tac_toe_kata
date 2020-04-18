import board.Board;
import board.Marker;
import board.Outcome;
import board.Position;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;
import turn.TurnCheckers;

import static board.Outcome.CROSS_WON;

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

    public Outcome outcome() {
        return CROSS_WON;
    }
}
