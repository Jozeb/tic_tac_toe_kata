import board.Marker;
import org.junit.Test;

import static board.Marker.CROSS;
import static board.Position.at;

public class TicTacGameShould {

    @Test
    public void moveCrossToPosition() {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        assert ticTacGame.is(CROSS, at(1, 1));
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void disallowMoveToSamePosition() throws PositionAlreadyFilledException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        ticTacGame.play0At(at(1, 1));
    }

    @Test
    public void moveNoughtToPosition() throws PositionAlreadyFilledException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.play(CROSS, at(1, 1));
        ticTacGame.play0At(at(1, 2));
        assert ticTacGame.isYAt(at(1, 2));
    }
}
