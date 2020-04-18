package win;

import board.Board;
import board.Positions;
import board.RowPositions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WinValidator {

    static final List<Positions> ALL_WINNING_POSITIONS = Arrays.asList(
            new RowPositions(1),
            new RowPositions(2),
            new RowPositions(3)
    );

    public Optional<Positions> isWin(Board board) {
        for (Positions positions : ALL_WINNING_POSITIONS) {
            if (board.markersAreAllTheSameAt(positions)) {
                return Optional.of(positions);
            }
        }
        return Optional.empty();
    }

}
