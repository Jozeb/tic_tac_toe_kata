package position;

public class Position {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 3;
    private final int row;
    private final int column;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Position at(int row, int column) {
        assertBoundsFor(row);
        assertBoundsFor(column);
        return new Position(row, column);
    }

    private static void assertBoundsFor(int value) {
        assert value >= LOWER_BOUND && value <= UPPER_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (row != position.row) return false;
        return column == position.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
