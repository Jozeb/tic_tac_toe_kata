import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicTacGameTest {

  @Test
  public void func() {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(5);
    assertEquals(State.PLAYER, ticTacGame.checkState(5));
  }
}
