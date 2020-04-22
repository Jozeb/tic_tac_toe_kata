package turn;

import board.Marker;
import position.Position;
import turn.exception.MustPlayCrossFirstException;

import static board.Marker.NOUGHT;

public class FirstPlayerTurnCheck implements PlayerTurnCheck {

    boolean played = false;
    private static final Marker MARKER = NOUGHT;

    public void forThe(Marker marker, Position position) throws MustPlayCrossFirstException {
        if (isFirstMoveMarker(marker) && notPlayed())
            throw new MustPlayCrossFirstException();
        played = true;
    }

    private boolean isFirstMoveMarker(Marker marker) {
        return MARKER == marker;
    }

    private boolean notPlayed() {
        return !played;
    }
}
