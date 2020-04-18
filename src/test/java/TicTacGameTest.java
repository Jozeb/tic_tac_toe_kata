import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicTacGameTest {

  @Test
  public void testPlayerMove_5() throws PositionAlreadyOccupiedException {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(5);
    assertEquals(State.PLAYER, ticTacGame.checkState(5));
  }

  @Test
  public void testComputerMove() throws PositionAlreadyOccupiedException {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(5);
    ticTacGame.computerMove(7);
    assertEquals(State.COMPUTER, ticTacGame.checkState(7));
  }

  @Test(expected = PositionAlreadyOccupiedException.class)
  public void testPlayerMoveWhenPositionIsAlreadyOccupied() throws PositionAlreadyOccupiedException {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(5);
    ticTacGame.computerMove(7);
    ticTacGame.playerMove(5);
  }

  @Test
  public void testPlayerMove() throws PositionAlreadyOccupiedException {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(5);
    ticTacGame.computerMove(7);
    ticTacGame.playerMove(6);
    assertEquals(State.PLAYER, ticTacGame.checkState(6));
  }

  @Test(expected = PositionAlreadyOccupiedException.class)
  public void testComputerMoveWhenPositionIsAlreadyOccupied() throws PositionAlreadyOccupiedException {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(5);
    ticTacGame.computerMove(7);
    ticTacGame.playerMove(6);
    ticTacGame.computerMove(7);
  }

  @Test
  public void testOutcomeWhenPlayerWon() throws PositionAlreadyOccupiedException {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(1);
    ticTacGame.computerMove(2);
    ticTacGame.playerMove(4);
    ticTacGame.computerMove(5);
    ticTacGame.playerMove(7);
    assertEquals("Player Won", ticTacGame.checkOutcome());
  }

  @Test
  public void testOutcomeWhenComputerWonOnMiddleColumn() throws PositionAlreadyOccupiedException {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(1);
    ticTacGame.computerMove(2);
    ticTacGame.playerMove(4);
    ticTacGame.computerMove(5);
    ticTacGame.playerMove(3);
    ticTacGame.computerMove(8);
    assertEquals("Computer Won", ticTacGame.checkOutcome());
  }

  @Test
  public void testOutcomeWhenComputerWonOnDiagonal() throws PositionAlreadyOccupiedException {
    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playerMove(2);
    ticTacGame.computerMove(1);
    ticTacGame.playerMove(4);
    ticTacGame.computerMove(5);
    ticTacGame.playerMove(3);
    ticTacGame.computerMove(9);
    assertEquals("Computer Won", ticTacGame.checkOutcome());
  }
}
