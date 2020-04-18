import board.Board;
import board.FirstMove;
import board.Marker;
import board.Position;
import exception.PlayCrossFirstException;
import exception.PositionAlreadyFilledException;

public class TicTacGame {

    Board board = new Board();

    FirstMove firstMove = new FirstMove();

    public void play(Marker marker, Position position) throws PositionAlreadyFilledException, PlayCrossFirstException {
        firstMove.check(marker);

        if (board.contains(position)) {
            throw new PositionAlreadyFilledException();
        }
        board.add(position, marker);
    }

    public boolean is(Marker cross, Position position) {
        return true;
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
