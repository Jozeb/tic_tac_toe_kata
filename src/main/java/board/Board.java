package board;

import java.util.HashSet;
import java.util.Set;

public class Board {
    Set<Position> board = new HashSet<>();
    public void add(Position position) {
        board.add(position);
    }
    public boolean contains(Position position) {
        return board.contains(position);
    }
}
