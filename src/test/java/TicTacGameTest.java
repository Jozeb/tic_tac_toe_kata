import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TicTacGameTest {

  @Test
  public void ticTacGameTest() throws OverlappingException {
    List<Integer> playerMoves = Arrays.asList(1);
    List<Integer> computerMoves = Arrays.asList(3);
    TicTacGame ticTacGame = new TicTacGame(playerMoves, computerMoves);
  }

  @Test(expected = OverlappingException.class)
  public void overlappingExceptionTest() throws OverlappingException {
    List<Integer> playerMoves = Arrays.asList(5);
    List<Integer> computerMoves = Arrays.asList(5);
    TicTacGame ticTacGame = new TicTacGame(playerMoves, computerMoves);
  }
}
