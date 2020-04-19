package gameplay;

import board.Board;
import win.WinValidator;

import java.util.Optional;

import static gameplay.OutcomeType.IN_PROGRESS;

public class GameOutcome {

    OutcomeType outcomeType = IN_PROGRESS;
    WinValidator winValidator = new WinValidator();

    public void updateBasedOn(Board board) {
        Optional<OutcomeType> outcome = winValidator.isWin(board);
        if (outcome.isPresent()) {
            this.outcomeType = outcome.get();
        }
    }

    public OutcomeType getOutcomeType() {
        return outcomeType;
    }
}
