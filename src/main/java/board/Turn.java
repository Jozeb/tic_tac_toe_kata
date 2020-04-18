package board;

import exception.PlayCrossException;
import exception.PlayNoughtException;
import exception.WrongMoveException;

import java.util.HashMap;
import java.util.Map;

import static board.Marker.NOUGHT;
import static board.Marker.CROSS;

public class Turn {

    Marker marker = null;

    Map<Marker, WrongMoveException> EXCEPTION_TO_THROW_FOR_MARKER = new HashMap() {{
        put(NOUGHT, new PlayCrossException());
        put(CROSS, new PlayNoughtException());
    }};

    public void check(Marker marker) throws WrongMoveException {
        if (lastMarkerAlso(marker)) {
            throw EXCEPTION_TO_THROW_FOR_MARKER.get(marker);
        }
        this.marker = marker;
    }

    private boolean lastMarkerAlso(Marker marker) {
        return marker == this.marker;
    }
}
