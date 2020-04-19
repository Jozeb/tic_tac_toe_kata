package gameplay.validators;

import static board.Marker.NOUGHT;
import static gameplay.GameState.WON_BY_NOUGHTS;

import board.Board;
import gameplay.GameState;
import win.AllWinningPositions;

public class NoughtWinValidator implements BoardValidator {

  final AllWinningPositions allWinningPositions = new AllWinningPositions();

  @Override
  public boolean isGameFinished(Board board) {
    return allWinningPositions.stream()
        .anyMatch(positions -> board.markersAreAllTheSameAt(positions, NOUGHT));
  }

  @Override
  public GameState getGameState() {
    return WON_BY_NOUGHTS;
  }
}
