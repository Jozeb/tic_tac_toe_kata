import com.game.tictactoe.TicTacGame;

import java.util.List;

import exceptions.IllegalMoveException;
import org.junit.Assert;
import org.junit.Before;
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

    TicTacGame ticTacGame;
    int GRID_NO;
    Character playerX = 'X';
    Character playerO = 'O';


    @Before
    public void init() {
        ticTacGame = new TicTacGame();
    }

    @Test
    public void markXOnBoard_When_PlayerGiveInput() {
        GRID_NO = 2;
        try {
            ticTacGame.playerMove(GRID_NO, playerX);
        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }
        List<Character> board = ticTacGame.getBoard();
        int index = GRID_NO - 1;
        Assert.assertEquals("output should be X", playerX, board.get(index));
    }

    /*
     when same player insert two input  in sequence:
     */
    @Test
    public void checkPlayer_Illegal_Move_Sequence() {
        try {
            GRID_NO = 2;
            ticTacGame.playerMove(GRID_NO, playerX);
            GRID_NO = 6;
            ticTacGame.playerMove(GRID_NO, playerX);
        } catch (IllegalMoveException e) {
            Assert.assertEquals("when same player insert two input  in sequence", "Illegal move:same player made a move  twice in a row", e.getMessage());
            System.out.println(e.getMessage());
        }
    }

  /**
   * When unknown player made a move
   *
   */

  @Test
    public void whenPlayer_insert_wrong_input(){
      Character unknownPlayer ='S';
      try {
        GRID_NO = 2;
        ticTacGame.playerMove(GRID_NO, unknownPlayer);
      } catch (IllegalMoveException e) {
        Assert.assertEquals("When unknown player made a move", "Illegal move:Unknown player made a move", e.getMessage());
        System.out.println(e.getMessage());
      }
    }


}
