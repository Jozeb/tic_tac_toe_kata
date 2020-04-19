package board;

import exception.PositionAlreadyFilledException;

import java.util.HashMap;
import java.util.Map;

import static board.Marker.EMPTY;

public class Board {
    Map<Position, Marker> board = new HashMap<>();
    private void add(Position position, Marker marker) {
        board.put(position, marker);
    }
    private boolean contains(Position position) {
        return board.get(position) != null;
    }
    public Marker whatIsAt(Position position) {
        Marker marker = board.get(position);
        if (marker == null)
            return EMPTY;
        return marker;
    }

    public void move(Marker marker, Position position) throws PositionAlreadyFilledException {
        if (contains(position))
            throw new PositionAlreadyFilledException();
        add(position, marker);
    }

    public boolean markersAreAllTheSameAt(Positions positions) {
        return positions.stream().map(this::whatIsAt).distinct().count() == 1;
    }

    public boolean markerIsNotEmpty(Position position) {
        return whatIsAt(position).isNotEmpty();
    }
}
