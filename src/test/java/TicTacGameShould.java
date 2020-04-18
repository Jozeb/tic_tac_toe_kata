import exception.PlayCrossException;
import exception.PlayCrossFirstException;
import exception.PlayNoughtException;
import exception.PositionAlreadyFilledException;
import exception.WrongMoveException;
import org.junit.Test;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static board.Position.at;

public class TicTacGameShould {

    @Test
    public void playCross() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        assert ticTacGame.is(CROSS, at(1, 1));
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void playNoughtAndCrossToSamePosition() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        ticTacGame.play(NOUGHT, at(1, 1));
    }

    @Test
    public void playNought() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        ticTacGame.play(NOUGHT, at(1, 2));
        assert ticTacGame.isYAt(at(1, 2));
    }

    @Test
    public void playCrossSecondTurn() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(2, 2));
        ticTacGame.play(NOUGHT, at(1, 1));
        ticTacGame.play(CROSS, at(1, 2));
        assert ticTacGame.is(CROSS, at(1, 2));
    }

    @Test(expected = PlayCrossFirstException.class)
    public void notAllowNoughtToPlayFirst() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(NOUGHT, at(1, 1));
    }

    @Test(expected = PlayCrossException.class)
    public void notAllowNoughtToPlayTwice() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        ticTacGame.play(NOUGHT, at(1, 2));
        ticTacGame.play(NOUGHT, at(1, 3));
    }

    @Test(expected = PlayNoughtException.class)
    public void notAllowCrossToPlayTwice() throws WrongMoveException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        ticTacGame.play(CROSS, at(1, 2));
    }
}
