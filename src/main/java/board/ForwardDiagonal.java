package board;

import static board.Position.at;

public class ForwardDiagonal extends Positions {
    public ForwardDiagonal() {
        super(at(1,3), at(2,2), at(3,1));
    }
}
