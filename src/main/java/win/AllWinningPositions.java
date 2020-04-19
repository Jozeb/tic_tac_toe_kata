package win;

import board.ColumnPositions;
import board.Positions;
import board.RowPositions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static board.Position.at;

public class AllWinningPositions {

    static final List<Positions> ALL_WINNING_POSITIONS = Arrays.asList(
            new RowPositions(1),
            new RowPositions(2),
            new RowPositions(3),
            new ColumnPositions(1),
            new ColumnPositions(2),
            new ColumnPositions(3),
            new Positions(at(1,1), at(2,2), at(3,3)),
            new Positions(at(1,3), at(2,2), at(3,1))
    );

    public Stream<Positions> stream() {
        return ALL_WINNING_POSITIONS.stream();
    }

}
