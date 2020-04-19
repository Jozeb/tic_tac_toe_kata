package gameplay;

import board.Board;
import board.Marker;
import java.util.Arrays;

import board.validators.DrawValidator;
import position.Column;
import position.Position;
import position.Row;
import win.WinValidator;

import java.util.Optional;

import static gameplay.GameState.IN_PROGRESS;

public class GameOutcome {

  GameState gameState = IN_PROGRESS;
  WinValidator winValidator = new WinValidator();
  DrawValidator drawValidator = new DrawValidator();

  public void updateBasedOn(Board board) {
    Optional<GameState> outcome = winValidator.isWin(board);
    if (outcome.isPresent()) {
      this.gameState = outcome.get();
      return; // TODO: Refactor to remove return statement
    }

    outcome = drawValidator.isDrawn(board);

    if (outcome.isPresent()) {
      this.gameState = outcome.get();
      return;
    }
  }

  public GameState getGameState() {
    return gameState;
  }

}
