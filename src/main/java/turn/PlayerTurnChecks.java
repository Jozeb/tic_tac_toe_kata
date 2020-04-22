package turn;

import board.Marker;
import exception.WrongPlayException;
import position.Position;

import java.util.Arrays;
import java.util.List;

public class PlayerTurnChecks {
    List<PlayerTurnCheck> playerTurnChecks = Arrays.asList(
            new FirstPlayerTurnCheck(),
            new ConsecutiveTurnsCheck(),
            new PositionAlreadyFilledCheck());

    public void runFor(Marker marker, Position position) throws WrongPlayException {
        for (PlayerTurnCheck playerTurnCheck : playerTurnChecks) {
            playerTurnCheck.forThe(marker, position);
        }
    }
}
