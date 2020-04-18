import board.Board;
import board.Marker;
import board.Outcome;
import board.Position;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;
import turn.TurnCheckers;
import board.Positions;
import win.WinValidator;

import java.util.Optional;

import static board.Marker.NOUGHT;
import static board.Outcome.CROSSES_WON;
import static board.Outcome.NOUGHTS_WON;

public class TicTacGame {

    final Board board = new Board();
    final TurnCheckers turnCheckers = new TurnCheckers();
    final WinValidator winValidator = new WinValidator();

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
        Optional<Positions> winningPositions = winValidator.isWin(board);
        if (winningPositions.isPresent()
                && whatIs(winningPositions.get().any()) == NOUGHT) {
            return NOUGHTS_WON;
        }
        return CROSSES_WON;
    }
}
