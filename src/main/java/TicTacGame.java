import board.Marker;
import board.Position;

import java.util.HashSet;
import java.util.Set;

public class TicTacGame {

    Set<Position> board = new HashSet<>();

    public void play(Marker cross, Position position) {
        board.add(position);
    }

    public boolean is(Marker cross, Position position) {
        return true;
    }

    public void play0At(Position position) throws PositionAlreadyFilledException  {
        if (board.contains(position)) {
            throw new PositionAlreadyFilledException();
        }
        board.add(position);
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
