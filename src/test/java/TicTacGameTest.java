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

  @Test //TODO:
  public void movesTest1(){
    int[] player1Moves = new int[]{1,5,8};
    int[] player2Moves = new int[]{3,6,9};
    Player player1 = new TestHumanPlayer("O",player1Moves);
    Player player2 = new TestComputerPlayer("X",player2Moves);

    TicTacToeGame game = new TicTacToeGame(player1, player2);
    int count = game.getMoveCount();
    boolean isPlayer1Turn = game.isPlayer1Turn();

    game.nextMove();
    String marker = game.getMarkerAt(0,0);


    Assert.assertEquals(player1.getMarker(),marker);
    Assert.assertEquals(count+1,game.moveCount());
    Assert.assertFalse(game.isGameFinished());
    Assert.assertNotEquals(isPlayer1Turn, game.getCurrentPlayerTurn());

  }


}
