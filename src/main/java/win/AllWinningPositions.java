package win;

import position.BackwardDiagonal;
import position.Column;
import position.ColumnPositions;
import position.ForwardDiagonal;
import position.Positions;
import position.Row;
import position.RowPositions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AllWinningPositions {

    static final List<Positions> ALL_WINNING_POSITIONS = Arrays.asList(
            new RowPositions(Row.ONE),
            new RowPositions(Row.TWO),
            new RowPositions(Row.THREE),
            new ColumnPositions(Column.ONE),
            new ColumnPositions(Column.TWO),
            new ColumnPositions(Column.THREE),
            new BackwardDiagonal(),
            new ForwardDiagonal()
    );

    public Stream<Positions> stream() {
        return ALL_WINNING_POSITIONS.stream();
    }
}
