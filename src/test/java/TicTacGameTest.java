import org.junit.Assert;
import org.junit.Test;

public class TicTacGameTest {

  @Test
  public void constructorTest1() {
    Player player1 = new HumanPlayer("O");
    Player player2 = new ComputerPlayer("X");

    TicTacToeGame game = new TicTacToeGame(player1, player2);

    Assert.assertEquals(player1, game.getPlayer1());
    Assert.assertEquals(player2, game.getPlayer2());
    Assert.assertEquals(game.getCurrentPlayer(), player1);
  }
}
