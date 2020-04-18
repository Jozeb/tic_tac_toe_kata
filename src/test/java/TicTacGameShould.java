import board.Outcome;
import exception.PlayCrossException;
import exception.PlayCrossFirstException;
import exception.PlayNoughtException;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;
import org.junit.Test;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static board.Marker.EMPTY;
import static board.Position.at;

public class TicTacGameShould {

    @Test
    public void indicateEmptyPosition() {
        TicTacGame ticTacGame = new TicTacGame();
        assert ticTacGame.whatIs(at(1, 1)) == EMPTY;
    }

    @Test
    public void playCross() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(1, 1));
        assert ticTacGame.whatIs(at(1, 1)) == CROSS;
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void playNoughtAndCrossToSamePosition() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 1));
    }

    @Test
    public void playNought() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 2));
        assert ticTacGame.whatIs(at(1, 2)) == NOUGHT;
    }

    @Test
    public void playCrossSecondTurn() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(2, 2))
                .play(NOUGHT, at(1, 1))
                .play(CROSS, at(1, 2));
        assert ticTacGame.whatIs(at(1, 2)) == CROSS;
    }

    @Test(expected = PlayCrossFirstException.class)
    public void notAllowNoughtToPlayFirst() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(NOUGHT, at(1, 1));
    }

    @Test(expected = PlayCrossException.class)
    public void notAllowNoughtToPlayTwice() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(1, 2))
                .play(NOUGHT, at(1, 3));
    }

    @Test(expected = PlayNoughtException.class)
    public void notAllowCrossToPlayTwice() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(CROSS, at(1, 2));
    }

    @Test
    public void winWhenCrossesLinedUpInFirstRow() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(2, 1))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(2, 2))
                .play(CROSS, at(1, 3));
        assert ticTacGame.outcome() == Outcome.CROSS_WON;
    }

    @Test
    public void winWhenNoughtsLinedUpInFirstRow() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(2, 1))
                .play(NOUGHT, at(1, 1))
                .play(CROSS, at(2, 2))
                .play(NOUGHT, at(1, 2))
                .play(CROSS, at(3, 3))
                .play(NOUGHT, at(1, 3));
        assert ticTacGame.outcome() == Outcome.NOUGHTS_WON;
    }

    @Test
    public void winWhenNoughtsLinedUpInSecondRow() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(2, 1))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(2, 2))
                .play(CROSS, at(3, 3))
                .play(NOUGHT, at(2, 3));
        assert ticTacGame.outcome() == Outcome.NOUGHTS_WON;
    }

    @Test
    public void winWhenNoughtsLinedUpInThirdRow() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame()
                .play(CROSS, at(1, 1))
                .play(NOUGHT, at(3, 1))
                .play(CROSS, at(1, 2))
                .play(NOUGHT, at(3, 2))
                .play(CROSS, at(2, 3))
                .play(NOUGHT, at(3, 3));
        assert ticTacGame.outcome() == Outcome.NOUGHTS_WON;
    }
}
