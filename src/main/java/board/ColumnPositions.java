package board;

import java.util.stream.IntStream;

import static board.Position.at;

public class ColumnPositions extends Positions {
    public ColumnPositions(int column) {
        super(IntStream.of(1, 2, 3)
                .mapToObj(row -> at(row, column))
                .toArray(Position[]::new));
    }
}
