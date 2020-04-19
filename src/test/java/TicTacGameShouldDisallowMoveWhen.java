import board.exception.PositionAlreadyFilledException;
import exception.WrongPlayException;
import org.junit.Test;
import position.Column;
import position.Row;
import turn.exception.CannotPlayCrossException;
import turn.exception.CannotPlayNoughtException;
import turn.exception.MustPlayCrossFirstException;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static position.Position.at;

public class TicTacGameShouldDisallowMoveWhen {

    @Test(expected = PositionAlreadyFilledException.class)
    public void playNoughtAndCrossToSamePosition() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.ONE));
    }

    @Test(expected = MustPlayCrossFirstException.class)
    public void notAllowNoughtToPlayFirst() throws WrongPlayException {
        new TicTacGame()
                .play(NOUGHT, at(Row.ONE, Column.ONE));
    }

    @Test(expected = CannotPlayNoughtException.class)
    public void notAllowNoughtToPlayTwice() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.THREE));
    }

    @Test(expected = CannotPlayCrossException.class)
    public void notAllowCrossToPlayTwice() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO));
    }
}
