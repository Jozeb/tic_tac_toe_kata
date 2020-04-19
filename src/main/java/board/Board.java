package board;

import board.exception.PositionAlreadyFilledException;
import position.Position;
import position.Positions;

import java.util.HashMap;
import java.util.Map;

import static board.Marker.EMPTY;

public class Board {
    Map<Position, Marker> board = new HashMap<>();

    private void add(Position position, Marker marker) {
        board.put(position, marker);
    }

    public Marker whatIsAt(Position position) {
        Marker marker = board.get(position);
        if (marker == null)
            return EMPTY;
        return marker;
    }

    public void move(Marker marker, Position position) {
        add(position, marker);
    }

    public boolean markersAreAllTheSameAt(Positions positions, Marker marker) {
        return positions.stream()
            .filter(position -> this.whatIsAt(position) == marker)
            .count() == 3;
    }
}
