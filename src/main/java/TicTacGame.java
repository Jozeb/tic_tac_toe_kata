import board.Marker;
import board.StatefulBoard;
import gameplay.GameState;
import position.Position;
import exception.WrongPlayException;
import turn.PlayerTurnChecks;

public class TicTacGame {

    final PlayerTurnChecks playerTurnChecks = new PlayerTurnChecks();
    final StatefulBoard statefulBoard = new StatefulBoard();

    public TicTacGame play(Marker marker, Position position) throws WrongPlayException {
        playerTurnChecks.runFor(marker, position);
        statefulBoard.play(marker, position);
        return this;
    }

    public void assertThat(Marker marker, Position position) {
        assert statefulBoard.exists(marker, position);
    }

    public void assertThatGameIs(GameState gameState) {
        assert statefulBoard.isState(gameState);
    }
}
