package gameplay;

import board.Board;
import board.Marker;
import java.util.Arrays;
import position.Column;
import position.Position;
import position.Row;
import win.WinValidator;

import java.util.Optional;

import static gameplay.GameState.IN_PROGRESS;

public class GameOutcome {

  GameState gameState = IN_PROGRESS;
  WinValidator winValidator = new WinValidator();

  public void updateBasedOn(Board board) {
    Optional<GameState> outcome = winValidator.isWin(board);
    if (outcome.isPresent()) {
      this.gameState = outcome.get();
    }

    long filledBoxesCount = Arrays.stream(Row.values())
        .map(row -> Arrays.stream(Column.values())
            .map(column -> Position.at(row, column))
            .map(board::whatIsAt)
            .filter(Marker::isNotEmpty)
            .count()).mapToInt(Math::toIntExact)
        .sum();

    if (filledBoxesCount == 9) {
        this.gameState = GameState.DRAWN;
    }

  }

  public GameState getGameState() {
    return gameState;
  }

}
