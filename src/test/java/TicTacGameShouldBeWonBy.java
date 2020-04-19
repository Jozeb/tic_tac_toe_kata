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
    public void winWhenCrossesLinedUpInFirstRow() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .play(NOUGHT, at(Row.TWO, Column.ONE))
                .play(CROSS, at(Row.ONE, Column.TWO))
                .play(NOUGHT, at(Row.TWO, Column.TWO))
                .play(CROSS, at(Row.ONE, Column.THREE))
                .assertThatGameIs(WON_BY_CROSSES);
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
                .assertThatGameIs(WON_BY_NOUGHTS);
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
                .assertThatGameIs(WON_BY_NOUGHTS);
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
                .assertThatGameIs(WON_BY_NOUGHTS);
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
                .assertThatGameIs(WON_BY_NOUGHTS);
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
                .assertThatGameIs(WON_BY_NOUGHTS);
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
                .assertThatGameIs(WON_BY_NOUGHTS);
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
                .assertThatGameIs(WON_BY_NOUGHTS);
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
                .assertThatGameIs(WON_BY_NOUGHTS);
    }
}
