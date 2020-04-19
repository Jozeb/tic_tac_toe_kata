package position;

import static position.Position.at;

public class BackwardDiagonal extends Positions {
    public BackwardDiagonal() {
        super(
                at(Row.ONE, Column.ONE),
                at(Row.TWO,Column.TWO),
                at(Row.THREE,Column.THREE));
    }
}
