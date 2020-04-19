package game;

import board.Board;
import board.Outcome;
import board.Positions;
import win.AllWinningPositions;

import java.util.Optional;

import static board.Marker.NOUGHT;
import static board.Outcome.CROSSES_WON;
import static board.Outcome.IN_PROGRESS;
import static board.Outcome.NOUGHTS_WON;

public class GameOutcome {

    Outcome outcome = IN_PROGRESS;
    final AllWinningPositions allWinningPositions = new AllWinningPositions();

    public void updateBasedOn(Board board) {
        Optional<Positions> winningPositions = allWinningPositions.isWin(board);
        if (winningPositions.isPresent()) {
            if (board.whatIsAt(winningPositions.get().any()) == NOUGHT) {
                outcome = NOUGHTS_WON;
            } else {
                outcome = CROSSES_WON;
            }
        }
    }

    public Outcome getOutcome() {
        return outcome;
    }
}
