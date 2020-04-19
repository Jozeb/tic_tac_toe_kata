package gameplay;

import board.Board;

import board.validators.*;

import java.util.Arrays;
import java.util.List;

import static gameplay.GameState.IN_PROGRESS;

public class GameOutcome {

  GameState gameState = IN_PROGRESS;
  List<BoardValidator> boardValidators;

  public GameOutcome() {
    boardValidators = Arrays.asList(new NoughtWinValidator(), new CrossWinValidator(), new DrawValidator());
  }

  public void updateBasedOn(Board board) {

    this.gameState = boardValidators.stream()
            .filter(validator -> validator.isGameFinished(board))
            .findFirst()
            .map(BoardValidator::getGameState)
            .orElse(IN_PROGRESS);
  }

  public GameState getGameState() {
    return gameState;
  }
}
