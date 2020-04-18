package win;

import board.Position;

import java.util.stream.IntStream;

import static board.Position.at;

public class RowWinningPositions extends WinningPositions {
    public RowWinningPositions(int row) {
        super(IntStream.of(1, 2, 3)
                .mapToObj(column -> at(row, column))
                .toArray(Position[]::new));
    }
}
