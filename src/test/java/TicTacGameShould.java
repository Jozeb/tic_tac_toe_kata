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
                .play(CROSS, at(1, 1))
                .assertThat(CROSS, at(1, 1));
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void playNoughtAndCrossToSamePosition() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 1));
    }

    @Test
    public void playNought() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 2))
                .assertThat(NOUGHT, at(1, 2));
    }

    @Test
    public void playCrossSecondTurn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(2, 2))
                .play(NOUGHT, at(1, 1))
                .play(CROSS, at(1, 2))
                .assertThat(CROSS, at(1, 2));
    }

    @Test(expected = MustPlayCrossFirstException.class)
    public void notAllowNoughtToPlayFirst() throws WrongPlayException {
        new TicTacGame()
                .play(NOUGHT, at(1, 1));
    }

    @Test(expected = CannotPlayNoughtException.class)
    public void notAllowNoughtToPlayTwice() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 2))
                .play(NOUGHT, at(1, 3));
    }

    @Test(expected = CannotPlayCrossException.class)
    public void notAllowCrossToPlayTwice() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(CROSS, at(1, 2));
    }

    @Test
    public void winWhenCrossesLinedUpInFirstRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(2, 1))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(2, 2))
                .play(CROSS, at(1, 3))
                .assertThat(CROSSES_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInFirstRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(2, 1))
                .play(NOUGHT, at(1, 1))
                .play(CROSS, at(2, 2))
                .play(NOUGHT, at(1, 2))
                .play(CROSS, at(3, 3))
                .play(NOUGHT, at(1, 3))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInSecondRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(2, 1))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(2, 2))
                .play(CROSS, at(3, 3))
                .play(NOUGHT, at(2, 3))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInThirdRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(3, 1))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(3, 2))
                .play(CROSS, at(2, 3))
                .play(NOUGHT, at(3, 3))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInFirstColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(1, 1))
                .play(CROSS, at(1, 3))
                .play(NOUGHT, at(2, 1))
                .play(CROSS, at(2, 3))
                .play(NOUGHT, at(3, 1))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInSecondColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 2))
                .play(CROSS, at(1, 3))
                .play(NOUGHT, at(2, 2))
                .play(CROSS, at(2, 1))
                .play(NOUGHT, at(3, 2))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInThirdColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 3))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(2, 3))
                .play(CROSS, at(2, 1))
                .play(NOUGHT, at(3, 3))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInFirstDiagonal() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(1, 1))
                .play(CROSS, at(1, 3))
                .play(NOUGHT, at(2, 2))
                .play(CROSS, at(2, 1))
                .play(NOUGHT, at(3, 3))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInSecondDiagonal() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 3))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(2, 2))
                .play(CROSS, at(2, 1))
                .play(NOUGHT, at(3, 1))
                .assertThat(NOUGHTS_WON);
    }

    @Test
    public void beInProgressWhenOnlyOneMove() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
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
