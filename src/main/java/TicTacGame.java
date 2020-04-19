import board.Board;
import board.Marker;
import gameplay.GameState;
import position.Position;
import exception.WrongPlayException;
import gameplay.GameOutcome;
import turn.PlayerTurnChecks;

public class TicTacGame {

    final Board board = new Board();
    final PlayerTurnChecks playerTurnChecks = new PlayerTurnChecks();
    final GameOutcome gameOutcome = new GameOutcome();

    public TicTacGame play(Marker marker, Position position) throws WrongPlayException {
        playerTurnChecks.runFor(marker);
        board.move(marker, position);
        gameOutcome.updateBasedOn(board);
        return this;
    }

    public void assertThat(Marker marker, Position position) {
        assert marker == board.whatIsAt(position);
    }

    public void assertThatGameIs(GameState gameState) {
        assert gameState == gameOutcome.getGameState();
    }
}
