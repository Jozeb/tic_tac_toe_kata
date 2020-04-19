import position.Column;
import position.Row;
import turn.exception.CannotPlayNoughtException;
import turn.exception.MustPlayCrossFirstException;
import turn.exception.CannotPlayCrossException;
import board.exception.PositionAlreadyFilledException;
import exception.WrongPlayException;
import org.junit.Test;

import static board.Marker.CROSS;
import static board.Marker.EMPTY;
import static board.Marker.NOUGHT;
import static gameplay.OutcomeType.CROSSES_WON;
import static gameplay.OutcomeType.IN_PROGRESS;
import static gameplay.OutcomeType.NOUGHTS_WON;
import static position.Position.at;

public class TicTacGameShould {

    @Test
    public void indicateEmptyPosition() {
        new TicTacGame()
                .assertThat(EMPTY, at(Row.ONE, Column.ONE));
    }

    @Test
    public void playCross() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .assertThat(CROSS, at(Row.ONE, Column.ONE));
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void playNoughtAndCrossToSamePosition() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.ONE));
    }

    @Test
    public void playNought() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.TWO))
                .assertThat(NOUGHT, at(Row.ONE, Column.TWO));
    }

    @Test
    public void playCrossSecondTurn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.TWO, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .assertThat(CROSS, at(Row.ONE, Column.TWO));
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

    @Test
    public void winWhenCrossesLinedUpInFirstRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.TWO, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .assertThat(CROSSES_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInFirstRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.TWO, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.TWO))
                .play(CROSS, at(Row.THREE, Column.THREE))
                .play(NOUGHT, at(Row.ONE, Column.THREE))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInSecondRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.TWO, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.THREE, Column.THREE))
                .play(NOUGHT, at(Row.TWO, Column.THREE))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInThirdRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.THREE, Column.TWO))
                .play(CROSS, at(Row.TWO, Column.THREE))
                .play(NOUGHT, at(Row.THREE, Column.THREE))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInFirstColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .play(NOUGHT, at(Row.TWO, Column.ONE))
                .play(CROSS, at(Row.TWO, Column.THREE))
                .play(NOUGHT, at(Row.THREE, Column.ONE))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInSecondColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.TWO))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.TWO))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInThirdColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.THREE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.THREE))
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.THREE))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInFirstDiagonal() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.THREE))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInSecondDiagonal() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.THREE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.ONE))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void beInProgressWhenOnlyOneMove() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .assertThat(IN_PROGRESS);
    }

    @Test(expected = AssertionError.class)
    public void notAllowOutOfBoundMovesZeroOrLess() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(0, 0));
    }

    @Test(expected = AssertionError.class)
    public void notAllowOutOfBoundMovesFourOrMore() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(4, 4));
    }
}
