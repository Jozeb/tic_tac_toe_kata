package board;

import java.util.HashMap;
import java.util.Map;

public class Board {
    Map<Position, Marker> board = new HashMap<>();
    public void add(Position position, Marker marker) {
        board.put(position, marker);
    }
    public boolean contains(Position position) {
        return board.get(position) != null;
    }
    public Marker whatIsAt(Position position) {
        Marker marker = board.get(position);
        return marker;
    }
}
