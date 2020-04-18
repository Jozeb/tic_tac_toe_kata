import board.Board;
import board.CheckFirstTurn;
import board.CheckTurn;
import board.Marker;
import board.Position;
import board.CheckTurnSequence;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacGame {

    Board board;
    List<CheckTurn> turnCheckers;

    TicTacGame() {
        board = new Board();
        turnCheckers = Arrays.asList(new CheckFirstTurn(), new CheckTurnSequence());
    }

    public void play(Marker marker, Position position) throws WrongMoveException {
        for (CheckTurn checkTurn: turnCheckers) {
            checkTurn.forThe(marker);
        }

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
