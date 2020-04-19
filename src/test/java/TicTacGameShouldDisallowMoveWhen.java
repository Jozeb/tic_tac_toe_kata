import board.exception.PositionAlreadyFilledException;
import exception.GameAlreadyEndedException;
import exception.WrongPlayException;
import org.junit.Test;
import position.Column;
import position.Row;
import turn.exception.CannotPlayCrossException;
import turn.exception.CannotPlayNoughtException;
import turn.exception.MustPlayCrossFirstException;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static gameplay.GameState.DRAWN;
import static gameplay.GameState.WON_BY_NOUGHTS;
import static position.Position.at;

public class TicTacGameShouldDisallowMoveWhen {

    @Test(expected = PositionAlreadyFilledException.class)
    public void noughtAndCrossPlayedToSamePosition() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.ONE));
    }

    @Test(expected = MustPlayCrossFirstException.class)
    public void noughtPlayedFirst() throws WrongPlayException {
        new TicTacGame()
                .play(NOUGHT, at(Row.ONE, Column.ONE));
    }

    @Test(expected = CannotPlayNoughtException.class)
    public void noughtPlayedTwice() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.THREE));
    }

    @Test(expected = CannotPlayCrossException.class)
    public void crossPlayedTwice() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO));
    }

    @Test(expected = GameAlreadyEndedException.class)
    public void moveAfterGameEnd() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.TWO, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.TWO))
                .play(CROSS, at(Row.THREE, Column.THREE))
                .play(NOUGHT, at(Row.ONE, Column.THREE))
                .play(CROSS, at(Row.TWO, Column.THREE));


    }
}
