import board.Board;
import board.FirstCross;
import board.Marker;
import board.Position;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;

public class TicTacGame {

    Board board = new Board();

    FirstCross crossPlayed = new FirstCross();

    public void play(Marker marker, Position position) throws PositionAlreadyFilledException, PlayCrossFirstException {
        if (NOUGHT == marker && !crossPlayed.played()) {
            throw new PlayCrossFirstException();
        }

        if (board.contains(position)) {
            throw new PositionAlreadyFilledException();
        }
        crossPlayed.play();
        board.add(position, marker);
    }

    public boolean is(Marker cross, Position position) {
        return true;
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
