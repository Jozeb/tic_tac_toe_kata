import board.Board;
import board.Marker;
import board.Outcome;
import position.Position;
import exception.WrongPlayException;
import game.GameOutcome;
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

    public void assertThat(Outcome outcome) {
        assert outcome == gameOutcome.getOutcome();
    }
}
