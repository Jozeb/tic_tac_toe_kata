import board.Marker;
import org.junit.Test;

import static board.Marker.CROSS;
import static board.Position.at;

public class TicTacGameShould {

    @Test
    public void playCross() {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        assert ticTacGame.is(CROSS, at(1, 1));
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void playNoughtAndCrossToSamePosition() throws PositionAlreadyFilledException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        ticTacGame.play0At(at(1, 1));
    }

    @Test
    public void playNought() throws PositionAlreadyFilledException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        ticTacGame.play0At(at(1, 2));
        assert ticTacGame.isYAt(at(1, 2));
    }

    @Test
    public void playCrossSecondTurn() throws PositionAlreadyFilledException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(2, 2));
        ticTacGame.play0At(at(1, 1));
        ticTacGame.play(CROSS, at(1, 2));
        assert ticTacGame.is(CROSS, at(1, 2));
    }
}
