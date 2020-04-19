package board.validators;

import board.Board;
import board.Marker;
import gameplay.GameState;
import win.AllWinningPositions;

import java.util.HashMap;
import java.util.Map;

import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static gameplay.GameState.WON_BY_NOUGHTS;

public class CrossWinValidator implements BoardValidator {

  final AllWinningPositions allWinningPositions = new AllWinningPositions();

  @Override
  public boolean getGameState(Board board) {
    return allWinningPositions.stream()
        .anyMatch(positions -> board.markersAreAllTheSameAt(positions, CROSS));
  }
}

