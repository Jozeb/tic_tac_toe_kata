package turn;

import board.Marker;
import exception.WrongMoveException;

import java.util.Arrays;
import java.util.List;

public class TurnCheckers {
    List<CheckTurn> turnCheckers = Arrays.asList(new CheckFirstTurn(), new CheckTurnSequence());

    public void runAllFor(Marker marker) throws WrongMoveException {
        for (CheckTurn checkTurn: turnCheckers) {
            checkTurn.forThe(marker);
        }
    }
}
