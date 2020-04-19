package win;

import board.Board;
import board.Marker;
import gameplay.GameState;
import position.Positions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static gameplay.GameState.WON_BY_CROSSES;
import static gameplay.GameState.WON_BY_NOUGHTS;

public class WinValidator {
    final AllWinningPositions allWinningPositions = new AllWinningPositions();
    final Map<Marker, GameState> OUTCOME_FOR = new HashMap() {{
        put(NOUGHT, WON_BY_NOUGHTS);
        put(CROSS, WON_BY_CROSSES);
    }};

    public Optional<GameState> isWin(Board board) {
        return allWinningPositions.stream()
                .filter(board::markersAreAllTheSameAt)
                .map(Positions::anyOne)
                .map(board::whatIsAt)
                .filter(Marker::isNotEmpty)
                .map(OUTCOME_FOR::get)
                .findFirst();
    }
}
