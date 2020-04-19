package board.validators;

import static board.Marker.NOUGHT;
import static gameplay.GameState.WON_BY_NOUGHTS;

import board.Board;
import board.Marker;
import gameplay.GameState;
import java.util.HashMap;
import java.util.Map;
import win.AllWinningPositions;

public class NoughtWinValidator  {

  final AllWinningPositions allWinningPositions = new AllWinningPositions();
  final Map<Marker, GameState> OUTCOME_FOR = new HashMap() {{
    put(NOUGHT, WON_BY_NOUGHTS);
  }};

  public boolean getGameState(Board board) {
    return allWinningPositions.stream()
        .anyMatch(positions -> board.markersAreAllTheSameAt(positions, NOUGHT));
  }
}

