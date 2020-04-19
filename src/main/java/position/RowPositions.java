package position;

import java.util.Arrays;
import java.util.stream.IntStream;

import static position.Position.at;

public class RowPositions extends Positions {
    public RowPositions(Row row) {
        super(Arrays.stream(Column.values())
                .map(column -> at(row, column))
                .toArray(Position[]::new));
    }
}
