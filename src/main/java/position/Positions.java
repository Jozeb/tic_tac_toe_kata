package position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public abstract class Positions {
    final List<Position> positions;

    public Positions(Position... positions) {
        this.positions = Arrays.asList(positions);
        assert positions.length > 0;
    }

    public Stream<Position> stream() {
        return positions.stream();
    }

    public Position anyOne() {
        return positions.get(0);
    }
}
