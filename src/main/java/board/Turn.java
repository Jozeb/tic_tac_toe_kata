package board;

import exception.PlayCrossException;
import exception.PlayNoughtException;

import static board.Marker.NOUGHT;

public class Turn {

    Marker lastMoveBy = null;

    public void check(Marker marker) throws PlayCrossException, PlayNoughtException {
        if (marker == lastMoveBy) {
            if (marker == NOUGHT) {
                throw new PlayCrossException();
            } else {
                throw new PlayNoughtException();
            }
        }
        lastMoveBy = marker;
    }
}
