package turn;

import board.Marker;
import exception.PlayCrossException;
import exception.PlayNoughtException;
import exception.WrongMoveException;

import java.util.HashMap;
import java.util.Map;

import static board.Marker.NOUGHT;
import static board.Marker.CROSS;

public class ConsecutiveTurnsCheck implements PlayerTurnCheck {

    Marker lastMarker = null;

    final static Map<Marker, WrongMoveException> EXCEPTION_TO_THROW = new HashMap() {{
        put(NOUGHT, new PlayCrossException());
        put(CROSS, new PlayNoughtException());
    }};

    public void forThe(Marker marker) throws WrongMoveException {
        if (lastMarkerAlso(marker)) {
            throw EXCEPTION_TO_THROW.get(marker);
        }
        this.lastMarker = marker;
    }

    private boolean lastMarkerAlso(Marker marker) {
        return marker == this.lastMarker;
    }
}
