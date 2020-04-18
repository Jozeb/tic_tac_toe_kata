import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TicTacGameTest {

    @Test
    public void GameExists() {
        TicTacGame ticTacGame = new TicTacGame();
    }

    @Test(expected = Exception.class)
    public void throwExceptionIfPlayer2TriesToMoveFirst() throws Exception {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.player2Move(3);
    }

    @Test
    public void ensurePlayer2MoviesSecond() throws Exception {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.player1Move(3);
        ticTacGame.player2Move(3);
    }

    @Test(expected = Exception.class)
    public void ensurePlayer1CannotMoveTwiceConsecutively() throws Exception {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.player1Move(3);
        ticTacGame.player1Move(3);
    }

    @Test(expected = Exception.class)
    public void ensurePlayer2CannotMoveTwiceConsecutively() throws Exception {
        TicTacGame ticTacGame = new TicTacGame();
        ticTacGame.player2Move(3);
        ticTacGame.player2Move(3);
    }

    @Test
    public void isValidBoardSize() {
        TicTacGame ticTacGame = new TicTacGame();
        int[][] actualValue = ticTacGame.getBoard();
      assertThat(actualValue).hasSize(3);
      for (int i = 0; i < 3; i++)
            assertThat(actualValue[i]).hasSize(3);
    }

    @Test
    public void translatePlayerTurnIntoGridPosition() throws Exception {
      TicTacGame ticTacGame = new TicTacGame();
       ticTacGame.player1Move(5);
       int [][] currentBoard=ticTacGame.getBoard();
       assertThat(currentBoard[1][1]).isEqualTo(1);
    }

}
