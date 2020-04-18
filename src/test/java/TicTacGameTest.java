import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicTacGameTest {

  @Test
  public void testPlayerMove_5() {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(5);
    assertEquals(State.PLAYER, ticTacGame.checkState(5));
  }

  @Test
  public void testComputerMove() {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(5);
    ticTacGame.computerMove(7);
    assertEquals(State.COMPUTER, ticTacGame.checkState(7));
  }

}
