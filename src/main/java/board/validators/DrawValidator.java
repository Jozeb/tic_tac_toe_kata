package board.validators;

import board.Board;
import board.Marker;
import gameplay.GameState;
import position.Column;
import position.Position;
import position.Row;

import java.util.Arrays;
import java.util.Optional;

public class DrawValidator {
    public Optional<GameState> isDrawn(Board board) {
        if (isBoardFull(board)) {
            return Optional.of(GameState.DRAWN);
        }

        return Optional.empty();
    }

    private boolean isBoardFull(Board board) {
        long filledBoxesCount = Arrays.stream(Row.values())
                .map(row -> Arrays.stream(Column.values())
                        .map(column -> Position.at(row, column))
                        .map(board::whatIsAt)
                        .filter(Marker::isNotEmpty)
                        .count()).mapToInt(Math::toIntExact)
                .sum();

        return filledBoxesCount == 9;
    }
}
