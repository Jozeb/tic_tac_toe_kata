package win;

import position.BackwardDiagonal;
import position.ColumnPositions;
import position.ForwardDiagonal;
import position.Positions;
import position.RowPositions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AllWinningPositions {

    static final List<Positions> ALL_WINNING_POSITIONS = Arrays.asList(
            new RowPositions(1),
            new RowPositions(2),
            new RowPositions(3),
            new ColumnPositions(1),
            new ColumnPositions(2),
            new ColumnPositions(3),
            new BackwardDiagonal(),
            new ForwardDiagonal()
    );

    public Stream<Positions> stream() {
        return ALL_WINNING_POSITIONS.stream();
    }
}
