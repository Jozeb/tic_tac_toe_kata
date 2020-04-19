package position;

import java.util.stream.IntStream;

import static position.Position.at;

public class Row extends Positions {
    public Row(int row) {
        super(IntStream
                .of(1, 2, 3)
                .mapToObj(column -> at(row, column))
                .toArray(Position[]::new));
    }
}
