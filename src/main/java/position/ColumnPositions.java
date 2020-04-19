package position;

import java.util.Arrays;
import java.util.stream.IntStream;

import static position.Position.at;

public class ColumnPositions extends Positions {
    public ColumnPositions(Column column) {
        super(Arrays.stream(Row.values())
                .map(row -> at(row, column))
                .toArray(Position[]::new));
    }
}
