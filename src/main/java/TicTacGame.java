import board.Board;
import board.FirstMove;
import board.Marker;
import board.Position;
import board.Turn;
import exception.PlayCrossException;
import exception.PlayCrossFirstException;
import exception.PlayNoughtException;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;

import static board.Marker.NOUGHT;

public class TicTacGame {

    Board board = new Board();

    FirstMove firstMove = new FirstMove();
    Turn turn = new Turn();

    public void play(Marker marker, Position position) throws WrongMoveException {
        firstMove.check(marker);
        turn.check(marker);

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
