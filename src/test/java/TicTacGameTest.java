import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TicTacGameTest {

  @Test
  public void GameExists() {
    TicTacGame ticTacGame = new TicTacGame();
  }

  @Test
  public void ensurePlayer1MovesFirst() {
    TicTacGame ticTacGame = new TicTacGame();
    assertThat(ticTacGame.firstMove)=1;
  }

}
