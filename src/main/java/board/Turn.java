package board;

import exception.PlayCrossException;
import exception.PlayNoughtException;

public class Turn {

    Marker marker = null;

    public void check(Marker marker) throws PlayCrossException, PlayNoughtException {
        if (lastMarkerAlso(marker)) {
            if (marker.isNought()) {
                throw new PlayCrossException();
            } else {
                throw new PlayNoughtException();
            }
        }
        this.marker = marker;
    }

    private boolean lastMarkerAlso(Marker marker) {
        return marker == this.marker;
    }
}
