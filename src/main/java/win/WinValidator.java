package win;

import board.Board;
import board.Marker;
import board.Outcome;
import board.Positions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static board.Outcome.CROSSES_WON;
import static board.Outcome.NOUGHTS_WON;

public class WinValidator {
    final AllWinningPositions allWinningPositions = new AllWinningPositions();
    final Map<Marker, Outcome> OUTCOME_FOR = new HashMap() {{
        put(NOUGHT, NOUGHTS_WON);
        put(CROSS, CROSSES_WON);
    }};

    public Optional<Outcome> isWin(Board board) {
        return allWinningPositions.stream()
                .filter(board::markersAreAllTheSameAt)
                .map(Positions::anyOne)
                .map(board::whatIsAt)
                .filter(Marker::isNotEmpty)
                .map(OUTCOME_FOR::get)
                .findFirst();
    }
}
