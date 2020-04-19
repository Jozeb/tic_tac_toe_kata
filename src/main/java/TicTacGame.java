import board.Board;
import board.Marker;
import board.Outcome;
import board.Position;
import exception.WrongMoveException;
import turn.TurnCheckers;
import board.Positions;
import win.AllWinningPositions;

import java.util.Optional;

import static board.Marker.NOUGHT;
import static board.Outcome.CROSSES_WON;
import static board.Outcome.IN_PROGRESS;
import static board.Outcome.NOUGHTS_WON;

public class TicTacGame {

    final Board board = new Board();
    final TurnCheckers turnCheckers = new TurnCheckers();
    final AllWinningPositions allWinningPositions = new AllWinningPositions();

    public TicTacGame play(Marker marker, Position position) throws WrongMoveException {
        turnCheckers.runAllFor(marker);
        board.move(marker, position);
        return this;
    }

    public void assertThat(Marker marker, Position position) {
        assert marker == board.whatIsAt(position);
    }

    public Outcome outcome() {
        Optional<Positions> winningPositions = allWinningPositions.isWin(board);
        if (winningPositions.isPresent()) {
            if (board.whatIsAt(winningPositions.get().any()) == NOUGHT) {
                return NOUGHTS_WON;
            } else {
                return CROSSES_WON;
            }
        }
        return IN_PROGRESS;
    }
}
