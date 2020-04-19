package position;

import static position.Position.at;

public class ForwardDiagonal extends Positions {
    public ForwardDiagonal() {
        super(
                at(Row.ONE, Column.THREE),
                at(Row.TWO, Column.TWO),
                at(Row.THREE, Column.ONE));
    }
}
