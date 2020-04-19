package gameplay;

import board.Board;

import board.validators.*;

import static gameplay.GameState.IN_PROGRESS;

public class GameOutcome {

  GameState gameState = IN_PROGRESS;

  public GameOutcome() {
  }

  public void updateBasedOn(Board board) {

    NoughtWinValidator noughtWinValidator = new NoughtWinValidator();
    boolean hasNoughtWon = noughtWinValidator.getGameState(board);
    if (hasNoughtWon) {
      this.gameState = GameState.WON_BY_NOUGHTS;
      return;
    }

    CrossWinValidator crossWinValidator = new CrossWinValidator();
    boolean hasCrossWon = crossWinValidator.getGameState(board);
    if (hasCrossWon) {
      this.gameState = GameState.WON_BY_CROSSES;
      return;
    }

    DrawValidator drawValidator = new DrawValidator();
    boolean isGameDrawn = drawValidator.getGameState(board);
    if (isGameDrawn) {
      this.gameState = GameState.DRAWN;
      return;
    }
  }

  public GameState getGameState() {
    return gameState;
  }

}
