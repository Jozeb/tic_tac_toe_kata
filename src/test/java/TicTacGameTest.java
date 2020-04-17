import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TicTacGameTest {

  @Test
  public void func() {
    TicTacGame ticTacGame = new TicTacGame();
    int[] playerMoves = {1,2,3,4};
    int[] computerMoves = {1,5,3,2};
    String gameResult = ticTacGame.playGame(playerMoves, computerMoves);

    assertThat(gameResult).isEqualTo("Match Draw");
  }
}
