package win;

import position.BackwardDiagonal;
import position.Column;
import position.ForwardDiagonal;
import position.Positions;
import position.Row;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AllWinningPositions {

    static final List<Positions> ALL_WINNING_POSITIONS = Arrays.asList(
            new Row(1),
            new Row(2),
            new Row(3),
            new Column(1),
            new Column(2),
            new Column(3),
            new BackwardDiagonal(),
            new ForwardDiagonal()
    );

    public Stream<Positions> stream() {
        return ALL_WINNING_POSITIONS.stream();
    }
}
