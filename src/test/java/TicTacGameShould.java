import org.junit.Test;

public class TicTacGameShould {
    @Test
    public void moveXToCorrectPosition() {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.playXAt(1, 1);
        assert ticTacGame.isXAt(1, 1);
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void disallowMoveToSamePosition() throws PositionAlreadyFilledException {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.playXAt(1, 1);
        ticTacGame.play0At(1, 1);
  }
}
