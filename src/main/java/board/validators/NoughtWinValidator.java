package board.validators;

import static board.Marker.NOUGHT;
import static gameplay.GameState.WON_BY_NOUGHTS;

import board.Board;
import board.Marker;
import gameplay.GameState;
import java.util.HashMap;
import java.util.Map;
import win.AllWinningPositions;

public class NoughtWinValidator implements BoardValidator {

  final AllWinningPositions allWinningPositions = new AllWinningPositions();

  @Override
  public boolean getGameState(Board board) {
    return allWinningPositions.stream()
        .anyMatch(positions -> board.markersAreAllTheSameAt(positions, NOUGHT));
  }
}

