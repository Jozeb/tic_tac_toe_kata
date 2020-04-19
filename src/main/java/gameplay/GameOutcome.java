package gameplay;

import board.Board;
import board.Marker;

import board.validators.*;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import static gameplay.GameState.IN_PROGRESS;

public class GameOutcome {

  GameState gameState = IN_PROGRESS;
  List<BoardValidator> boardValidators;

  public GameOutcome() {
    boardValidators = Arrays.asList(new DrawValidator());
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

    Optional<GameState> gameState = boardValidators.stream()
            .map(validator -> validator.getGameState(board))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst();
    if (gameState.isPresent())
        this.gameState = gameState.get();
  }

  public GameState getGameState() {
    return gameState;
  }

}
