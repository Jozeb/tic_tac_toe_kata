package position;

import static position.Position.at;

public class BackwardDiagonal extends Positions {
    public BackwardDiagonal() {
        super(at(1,1), at(2,2), at(3,3));
    }
}
