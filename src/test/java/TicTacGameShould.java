import exception.WrongPlayException;
import org.junit.Test;
import position.Column;
import position.Row;

import static board.Marker.CROSS;
import static board.Marker.EMPTY;
import static board.Marker.NOUGHT;
import static gameplay.GameState.IN_PROGRESS;
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

    @Test
    public void beInProgressWhenOnlyOneMove() throws WrongPlayException {
        new TicTacGame()
                .play(CROSS, at(Row.ONE, Column.ONE))
                .assertThatGameIs(IN_PROGRESS);
    }
}
