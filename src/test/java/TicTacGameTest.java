import com.game.tictactoe.TicTacGame;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TicTacGameTest {

  //player: 1 , 4 , 3
  // computer: 2, 5, 1

  // mark in a box by player
  // acceptable symbol are X or O
  // swtich between players one by one
  // Game grid , array 2D
  // Win coditions
  // Draw condition

  @Test
  public void markXOnBoard_When_PlayerGiveInput() {
    TicTacGame ticTacGame = new TicTacGame();
    int GRID_NO = 2;
    Character playerMark = 'X';

    ticTacGame.playerMove(GRID_NO, playerMark);
    List<Character> board = ticTacGame.getBoard();

    int index = GRID_NO - 1;
    Assert.assertEquals("output should be X", playerMark, board.get(index));
  }


}
