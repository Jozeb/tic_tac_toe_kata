import exception.WrongPlayException;
import org.junit.Test;
import position.Column;
import position.Row;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static gameplay.GameState.WON_BY_CROSSES;
import static gameplay.GameState.WON_BY_NOUGHTS;
import static position.Position.at;

public class TicTacGameShouldBeWonBy {

    @Test
    public void crossesWhenLinedUpInFirstRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.TWO, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .assertThatGameIs(WON_BY_CROSSES);
    }

    @Test
    public void noughtsWhenLinedUpInFirstRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.TWO, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.TWO))
                .play(CROSS, at(Row.THREE, Column.THREE))
                .play(NOUGHT, at(Row.ONE, Column.THREE))
                .assertThatGameIs(WON_BY_NOUGHTS);
    }

    @Test
    public void noughtsWhenLinedUpInSecondRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.TWO, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.THREE, Column.THREE))
                .play(NOUGHT, at(Row.TWO, Column.THREE))
                .assertThatGameIs(WON_BY_NOUGHTS);
    }

    @Test
    public void noughtsWhenLinedUpInThirdRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.THREE, Column.TWO))
                .play(CROSS, at(Row.TWO, Column.THREE))
                .play(NOUGHT, at(Row.THREE, Column.THREE))
                .assertThatGameIs(WON_BY_NOUGHTS);
    }

    @Test
    public void noughtsWhenLinedUpInFirstColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .play(NOUGHT, at(Row.TWO, Column.ONE))
                .play(CROSS, at(Row.TWO, Column.THREE))
                .play(NOUGHT, at(Row.THREE, Column.ONE))
                .assertThatGameIs(WON_BY_NOUGHTS);
    }

    @Test
    public void noughtsWhenLinedUpInSecondColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.TWO))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.TWO))
                .assertThatGameIs(WON_BY_NOUGHTS);
    }

    @Test
    public void noughtsWhenLinedUpInThirdColumn() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.THREE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.THREE))
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.THREE))
                .assertThatGameIs(WON_BY_NOUGHTS);
    }

    @Test
    public void NoughtsWhenLinedUpInFirstDiagonal() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.ONE, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.THREE))
                .assertThatGameIs(WON_BY_NOUGHTS);
    }

    @Test
    public void noughtsWhenLinedUpInSecondDiagonal() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.ONE, Column.THREE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.TWO, Column.ONE))
                .play(NOUGHT, at(Row.THREE, Column.ONE))
                .assertThatGameIs(WON_BY_NOUGHTS);
    }
}
