package win;

import board.Board;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static board.Position.at;

public class WinValidator {

    static final List<WinningPositions> ALL_WINNING_POSITIONS = Arrays.asList(
            new WinningPositions(at(1,1), at(1,2), at(1,3)),
            new WinningPositions(at(2,1), at(2,2), at(2,3)),
            new WinningPositions(at(3,1), at(3,2), at(3,3))
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
