package turn;

import board.Marker;
import exception.WrongMoveException;

import java.util.Arrays;
import java.util.List;

public class PlayerTurnChecks {
    List<PlayerTurnCheck> playerTurnChecks = Arrays.asList(
            new FirstPlayerTurnCheck(),
            new ConsecutiveTurnsCheck());

    public void runFor(Marker marker) throws WrongMoveException {
        for (PlayerTurnCheck playerTurnCheck : playerTurnChecks) {
            playerTurnCheck.forThe(marker);
        }
    }
}
