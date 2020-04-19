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

    if (isBoardFull(board)) {
      this.gameState = GameState.DRAWN;
    }
  }

  private boolean isBoardFull(Board board) {
    long filledBoxesCount = Arrays.stream(Row.values())
        .map(row -> Arrays.stream(Column.values())
            .map(column -> Position.at(row, column))
            .map(board::whatIsAt)
            .filter(Marker::isNotEmpty)
            .count()).mapToInt(Math::toIntExact)
        .sum();

    return filledBoxesCount == 9;
  }

  public GameState getGameState() {
    return gameState;
  }

}
