import board.Board;
import board.Marker;
import board.Outcome;
import board.Position;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;
import turn.TurnCheckers;
import win.WinningPositions;

import java.util.Arrays;
import java.util.List;

import static board.Marker.NOUGHT;
import static board.Outcome.CROSSES_WON;
import static board.Outcome.NOUGHTS_WON;
import static board.Position.at;

public class TicTacGame {

    final Board board = new Board();
    final TurnCheckers turnCheckers = new TurnCheckers();

    static final List<WinningPositions> ALL_WINNING_POSITIONS = Arrays.asList(
            new WinningPositions(at(1,1), at(1,2), at(1,3)),
            new WinningPositions(at(2,1), at(2,2), at(2,3)),
            new WinningPositions(at(3,1), at(3,2), at(3,3))
    );

    public TicTacGame play(Marker marker, Position position) throws WrongMoveException {
        turnCheckers.runAllFor(marker);

        if (board.contains(position)) {
            throw new PositionAlreadyFilledException();
        }
        board.add(position, marker);
        return this;
    }

    public Marker whatIs(Position position) {
        return board.whatIsAt(position);
    }

    public Outcome outcome() {
        for (WinningPositions winningPositions: ALL_WINNING_POSITIONS) {
            if (winningPositions.stream().map(this::whatIs).distinct().count() == 1) {
                if (whatIs(winningPositions.any()) == NOUGHT) {
                    return NOUGHTS_WON;
                }
            }
        }
        return CROSSES_WON;
    }
}
