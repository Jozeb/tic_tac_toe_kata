package board.validators;

import board.Board;
import board.Marker;
import gameplay.GameState;
import position.Column;
import position.Position;
import position.Row;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class DrawValidator implements BoardValidator {
    public Optional<GameState> getGameState(Board board) {
        if (isBoardFull(board)) {
            return Optional.of(GameState.DRAWN);
        }

        return Optional.empty();
    }

    private boolean isBoardFull(Board board) {
        Stream<Position> positions = Arrays.stream(Row.values())
                .flatMap(row -> Arrays.stream(Column.values()).map(column -> Position.at(row, column)));

        return positions.map(board::whatIsAt)
                .noneMatch(Marker::isEmpty);
    }
}
