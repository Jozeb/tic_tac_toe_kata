import org.junit.Test;

public class TicTacGameShould {

    @Test
    public void moveXToPosition() {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.playXAt(new Position(1, 1));
        assert ticTacGame.isXAt(new Position(1, 1));
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void disallowMoveToSamePosition() throws PositionAlreadyFilledException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.playXAt(new Position(1, 1));
        ticTacGame.play0At(new Position(1, 1));
    }

    @Test
    public void move0ToPosition() throws PositionAlreadyFilledException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.playXAt(new Position(1, 1));
        ticTacGame.play0At(new Position(1, 2));
        assert ticTacGame.isYAt(new Position(1, 2));
    }
}
