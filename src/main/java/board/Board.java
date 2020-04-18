package board;

import java.util.HashMap;
import java.util.Map;

import static board.Marker.EMPTY;

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
        if (marker == null)
            return EMPTY;
        return marker;
    }

    public boolean markersAreAllTheSameAt(Positions positions) {
        return whatIsAt(positions.any()).isNotEmpty() &&
                positions.stream().map(this::whatIsAt).distinct().count() == 1;
    }
}
