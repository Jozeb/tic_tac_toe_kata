package board.validators;

import board.Board;
import gameplay.GameState;
import win.AllWinningPositions;

import static board.Marker.CROSS;
import static gameplay.GameState.WON_BY_CROSSES;

public class CrossWinValidator implements BoardValidator {

  final AllWinningPositions allWinningPositions = new AllWinningPositions();

  @Override
  public boolean isGameFinished(Board board) {
    return allWinningPositions.stream()
        .anyMatch(positions -> board.markersAreAllTheSameAt(positions, CROSS));
  }

  @Override
  public GameState getGameState() {
    return WON_BY_CROSSES;
  }
}

