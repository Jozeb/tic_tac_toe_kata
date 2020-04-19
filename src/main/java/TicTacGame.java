import board.Board;
import board.Marker;
import exception.GameAlreadyEndedException;
import gameplay.GameState;
import gameplay.validators.InvalidMoveDetector;
import position.Position;
import exception.WrongPlayException;
import gameplay.GameOutcome;
import turn.PlayerTurnChecks;

public class TicTacGame {

    final Board board = new Board();
    final PlayerTurnChecks playerTurnChecks = new PlayerTurnChecks();
    final GameOutcome gameOutcome = new GameOutcome();
    final InvalidMoveDetector invalidMoveDetector = new InvalidMoveDetector();

    public TicTacGame play(Marker marker, Position position) throws WrongPlayException {
        invalidMoveDetector.detect(gameOutcome.getGameState());

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
