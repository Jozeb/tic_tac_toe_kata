import board.Board;
import board.Marker;
import board.Outcome;
import board.Position;
import exception.WrongMoveException;
import game.GameOutcome;
import turn.TurnCheckers;

public class TicTacGame {

    final Board board = new Board();
    final TurnCheckers turnCheckers = new TurnCheckers();
    final GameOutcome gameOutcome = new GameOutcome();

    public TicTacGame play(Marker marker, Position position) throws WrongMoveException {
        turnCheckers.runAllFor(marker);
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
