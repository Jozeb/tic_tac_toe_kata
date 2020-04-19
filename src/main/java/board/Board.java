package board;

import static board.Marker.EMPTY;

import java.util.HashMap;
import java.util.Map;
import position.Position;
import position.Positions;

public class Board {
    Map<Position, Marker> board = new HashMap<>();

    public Marker whatIsAt(Position position) {
        Marker marker = board.get(position);
        if (marker == null)
            return EMPTY;
        return marker;
    }

    public void add(Marker marker, Position position) {
        board.put(position, marker);
    }

    public boolean markersAreAllTheSameAt(Positions positions, Marker marker) {
        return positions.stream()
            .filter(position -> this.whatIsAt(position) == marker)
            .count() == 3;
    }
}
