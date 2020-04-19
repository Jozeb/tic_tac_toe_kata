import board.Board;
import board.Marker;
import board.Outcome;
import board.Position;
import exception.WrongMoveException;
import game.GameOutcome;
import turn.PlayerTurnChecks;

public class TicTacGame {

    final Board board = new Board();
    final PlayerTurnChecks playerTurnChecks = new PlayerTurnChecks();
    final GameOutcome gameOutcome = new GameOutcome();

    public TicTacGame play(Marker marker, Position position) throws WrongMoveException {
        playerTurnChecks.runFor(marker);
        board.move(marker, position);
        gameOutcome.updateBasedOn(board);
        return this;
    }

    public void assertThat(Marker marker, Position position) {
        assert marker == board.whatIsAt(position);
    }

    public void assertThat(Outcome outcome) {
        assert outcome == gameOutcome.getOutcome();
    }
}
