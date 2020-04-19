package game;

import board.Board;
import board.Outcome;
import win.WinValidator;

import java.util.Optional;

import static board.Outcome.IN_PROGRESS;

public class GameOutcome {

    Outcome outcome = IN_PROGRESS;
    WinValidator winValidator = new WinValidator();

    public void updateBasedOn(Board board) {
        Optional<Outcome> outcome = winValidator.isWin(board);
        if (outcome.isPresent()) {
            this.outcome = outcome.get();
        }
    }

    public Outcome getOutcome() {
        return outcome;
    }
}
