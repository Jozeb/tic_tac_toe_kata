import board.Board;
import board.FirstMove;
import board.Marker;
import board.Position;
import exception.PlayCrossException;
import exception.PlayCrossFirstException;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;

public class TicTacGame {

    Board board = new Board();

    FirstMove firstMove = new FirstMove();

    Marker lastMoveBy = null;

    public void play(Marker marker, Position position) throws WrongMoveException {
        firstMove.check(marker);
        if (marker == lastMoveBy) {
            throw new PlayCrossException();
        }

        if (board.contains(position)) {
            throw new PositionAlreadyFilledException();
        }
        board.add(position, marker);
        lastMoveBy = marker;
    }

    public boolean is(Marker cross, Position position) {
        return true;
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
