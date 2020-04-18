import board.Board;
import board.Marker;
import board.Position;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;

public class TicTacGame {

    Board board = new Board();

    boolean crossPlayed = false;

    public void play(Marker marker, Position position) throws PositionAlreadyFilledException, PlayCrossFirstException {
        if (NOUGHT == marker && !crossPlayed) {
            throw new PlayCrossFirstException();
        }

        if (board.contains(position)) {
            throw new PositionAlreadyFilledException();
        }
        crossPlayed = true;
        board.add(position, marker);
    }

    public boolean is(Marker cross, Position position) {
        return true;
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
