import board.Board;
import board.Marker;
import board.Outcome;
import board.Position;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;
import turn.TurnCheckers;

import static board.Marker.NOUGHT;
import static board.Outcome.CROSS_WON;
import static board.Outcome.NOUGHTS_WON;
import static board.Position.at;

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

    public Marker whatIs(Position position) {
        return board.whatIsAt(position);
    }

    public Outcome outcome() {
        Marker marker = whatIs(at(1, 1));
        if (marker == whatIs(at(1, 2)) && marker == whatIs(at(1,3))) {
            if (marker == NOUGHT) {
                return NOUGHTS_WON;
            }
        }
        marker = whatIs(at(2, 1));
        if (marker == whatIs(at(2, 2)) && marker == whatIs(at(2,3))) {
            if (marker == NOUGHT) {
                return NOUGHTS_WON;
            }
        }
        return CROSS_WON;
    }
}
