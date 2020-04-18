import board.Marker;
import board.Position;

import static board.Position.at;

public class TicTacGame {
    public void play(Marker cross, Position position) {
    }

    public boolean isXAt(Position position) {
        return true;
    }

    public void play0At(Position position) throws PositionAlreadyFilledException  {
        if (position.equals(at(1,1))) {
            throw new PositionAlreadyFilledException();
        }
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
