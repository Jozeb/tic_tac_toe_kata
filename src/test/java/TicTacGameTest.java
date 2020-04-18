import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

  @Test
  public void movesTest1(){
    List<Pair<Integer, Integer>> player1Moves = new ArrayList<>();
    player1Moves.add(new Pair<>(0, 0));

    List<Pair<Integer, Integer>> player2Moves = new ArrayList<>();
    player2Moves.add(new Pair<>(0, 0));

    Player player1 = new TestHumanPlayer("O", player1Moves);
    Player player2 = new TestComputerPlayer("X", player2Moves);

    TicTacToeGame game = new TicTacToeGame(player1, player2);
    int count = game.getMoveCount();
    boolean isPlayer1Turn = game.isPlayer1Turn();

    game.nextMove();

    String marker = game.getMarkerAt(0,0);

    Assert.assertEquals(player1.getMarker(),marker);
    Assert.assertEquals(count + 1, game.getMoveCount());
    Assert.assertFalse(game.isGameFinished());
    Assert.assertNotEquals(isPlayer1Turn, game.isPlayer1Turn());
  }
}
