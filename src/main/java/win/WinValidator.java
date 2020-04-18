package win;

import board.Board;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WinValidator {

    static final List<WinningPositions> ALL_WINNING_POSITIONS = Arrays.asList(
            new RowWinningPositions(1),
            new RowWinningPositions(2),
            new RowWinningPositions(3)
    );

    public Optional<WinningPositions> isWin(Board board) {
        for (WinningPositions winningPositions: ALL_WINNING_POSITIONS) {
            if (markersAreAllTheSameAt(board, winningPositions)) {
                return Optional.of(winningPositions);
            }
        }
        return Optional.empty();
    }

    private boolean markersAreAllTheSameAt(Board board, WinningPositions winningPositions) {
        return winningPositions.stream().map(board::whatIsAt).distinct().count() == 1;
    }
}
