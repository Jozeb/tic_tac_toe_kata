package gameplay.validators;

import board.Board;
import gameplay.GameState;
import position.Positions;
import win.AllWinningPositions;

import java.util.function.Predicate;

import static board.Marker.CROSS;
import static gameplay.GameState.WON_BY_CROSSES;

public class CrossWinValidator implements BoardValidator {

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
                .allMatch(CROSS::equals);
    }

    @Override
    public GameState getGameState() {
        return WON_BY_CROSSES;
    }
}

