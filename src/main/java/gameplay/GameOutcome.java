package gameplay;

import board.Board;
import board.Marker;

import board.validators.NoughtWinValidator;
import java.util.ArrayList;
import java.util.Arrays;

import board.validators.BoardValidator;
import board.validators.DrawValidator;
import board.validators.WinValidator;

import java.util.List;
import java.util.Optional;

import static gameplay.GameState.IN_PROGRESS;

public class GameOutcome {

  GameState gameState = IN_PROGRESS;
  List<BoardValidator> boardValidators;

  public GameOutcome() {
    boardValidators = Arrays.asList(new WinValidator(), new DrawValidator());
  }

  public void updateBasedOn(Board board) {

    NoughtWinValidator noughtWinValidator = new NoughtWinValidator();
    boolean hasNoughtWon = noughtWinValidator.getGameState(board);
    if (hasNoughtWon) {
      this.gameState = GameState.WON_BY_NOUGHTS;
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
