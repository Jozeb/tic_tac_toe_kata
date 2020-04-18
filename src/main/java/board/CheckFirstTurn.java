package board;

import exception.PlayCrossFirstException;

import static board.Marker.NOUGHT;

public class CheckFirstTurn implements CheckTurn {

    boolean played = false;
    private static final Marker MARKER = NOUGHT;

    public void forThe(Marker marker) throws PlayCrossFirstException {
        if (isFirstMoveMarker(marker) && notPlayed())
            throw new PlayCrossFirstException();
        played = true;
    }

    private boolean isFirstMoveMarker(Marker marker) {
        return MARKER == marker;
    }

    private boolean notPlayed() {
        return !played;
    }
}
