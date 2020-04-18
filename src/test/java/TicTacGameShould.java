import org.junit.Test;

public class TicTacGameShould {
    @Test
    public void makeXMoveToCorrectPosition() {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.playXAt(1, 1);
        assert ticTacGame.isXAt(1, 1);
  }
}
