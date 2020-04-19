package turn;

import board.Marker;
import exception.CannotPlayNoughtException;
import exception.CannotPlayCrossException;
import exception.WrongPlayException;

import java.util.HashMap;
import java.util.Map;

import static board.Marker.NOUGHT;
import static board.Marker.CROSS;

public class ConsecutiveTurnsCheck implements PlayerTurnCheck {

    Marker lastMarker = null;

    final static Map<Marker, WrongPlayException> EXCEPTION_TO_THROW = new HashMap() {{
        put(NOUGHT, new CannotPlayNoughtException());
        put(CROSS, new CannotPlayCrossException());
    }};

    public void forThe(Marker marker) throws WrongPlayException {
        if (lastMarkerAlso(marker)) {
            throw EXCEPTION_TO_THROW.get(marker);
        }
        this.lastMarker = marker;
    }

    private boolean lastMarkerAlso(Marker marker) {
        return marker == this.lastMarker;
    }
}
