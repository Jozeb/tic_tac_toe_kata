package position;

import java.util.stream.IntStream;

import static position.Position.at;

public class Column extends Positions {
    public Column(int column) {
        super(IntStream
                .of(1, 2, 3)
                .mapToObj(row -> at(row, column))
                .toArray(Position[]::new));
    }
}
