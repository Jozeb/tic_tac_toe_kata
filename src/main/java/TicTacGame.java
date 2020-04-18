import board.Board;
import board.FirstMove;
import board.Marker;
import board.Position;
import board.CheckTurn;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;

public class TicTacGame {

    Board board = new Board();

    FirstMove firstMove = new FirstMove();
    CheckTurn checkTurn = new CheckTurn();

    public void play(Marker marker, Position position) throws WrongMoveException {
        firstMove.check(marker);
        checkTurn.forThe(marker);

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
