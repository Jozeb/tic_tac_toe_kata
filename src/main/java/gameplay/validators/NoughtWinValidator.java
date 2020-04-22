package gameplay.validators;

import static board.Marker.NOUGHT;
import static gameplay.GameState.WON_BY_NOUGHTS;

import board.Board;
import gameplay.GameState;
import position.Positions;
import win.AllWinningPositions;

import java.util.function.Predicate;

public class NoughtWinValidator implements BoardValidator {

    final AllWinningPositions allWinningPositions = new AllWinningPositions();

    @Override
    public boolean isGameFinished(Board board) {
        return allWinningPositions
                .stream()
                .anyMatch(matchAll(board));
    }

    private Predicate<Positions> matchAll(Board board) {
        return positions -> positions.stream()
                .map(board::whatIsAt)
                .allMatch(NOUGHT::equals);
    }

    @Override
    public GameState getGameState() {
        return WON_BY_NOUGHTS;
    }
}
