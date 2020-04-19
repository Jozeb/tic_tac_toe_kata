import exception.PlayCrossException;
import exception.PlayCrossFirstException;
import exception.PlayNoughtException;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;
import org.junit.Test;

import static board.Marker.CROSS;
import static board.Marker.EMPTY;
import static board.Marker.NOUGHT;
import static board.Outcome.CROSSES_WON;
import static board.Outcome.IN_PROGRESS;
import static board.Outcome.NOUGHTS_WON;
import static position.Position.at;

public class TicTacGameShould {

    @Test
    public void indicateEmptyPosition() {
        new TicTacGame()
                .assertThat(EMPTY, at(1, 1));
    }

    @Test
    public void playCross() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .assertThat(CROSS, at(1, 1));
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void playNoughtAndCrossToSamePosition() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 1));
    }

    @Test
    public void playNought() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 2))
                .assertThat(NOUGHT, at(1, 2));
    }

    @Test
    public void playCrossSecondTurn() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(2, 2))
                .play(NOUGHT, at(1, 1))
                .play(CROSS, at(1, 2))
                .assertThat(CROSS, at(1, 2));
    }

    @Test(expected = PlayCrossFirstException.class)
    public void notAllowNoughtToPlayFirst() throws WrongMoveException {
        new TicTacGame()
                .play(NOUGHT, at(1, 1));
    }

    @Test(expected = PlayCrossException.class)
    public void notAllowNoughtToPlayTwice() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 2))
                .play(NOUGHT, at(1, 3));
    }

    @Test(expected = PlayNoughtException.class)
    public void notAllowCrossToPlayTwice() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(CROSS, at(1, 2));
    }

    @Test
    public void winWhenCrossesLinedUpInFirstRow() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(2, 1))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(2, 2))
                .play(CROSS, at(1, 3))
                .assertThat(CROSSES_WON);
    }

    @Test
    public void winWhenNoughtsLinedUpInFirstRow() throws WrongMoveException {
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
    public void winWhenNoughtsLinedUpInSecondRow() throws WrongMoveException {
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
    public void winWhenNoughtsLinedUpInThirdRow() throws WrongMoveException {
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
    public void winWhenNoughtsLinedUpInFirstColumn() throws WrongMoveException {
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
    public void winWhenNoughtsLinedUpInSecondColumn() throws WrongMoveException {
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
    public void winWhenNoughtsLinedUpInThirdColumn() throws WrongMoveException {
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
    public void winWhenNoughtsLinedUpInFirstDiagonal() throws WrongMoveException {
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
    public void winWhenNoughtsLinedUpInSecondDiagonal() throws WrongMoveException {
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
    public void beInProgressWhenOnlyOneMove() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(1, 1))
                .assertThat(IN_PROGRESS);
    }

    @Test(expected = AssertionError.class)
    public void notAllowOutOfBoundMovesZeroOrLess() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(0, 0));
    }

    @Test(expected = AssertionError.class)
    public void notAllowOutOfBoundMovesFourOrMore() throws WrongMoveException {
        new TicTacGame()
                .play(CROSS, at(4, 4));
    }
}
