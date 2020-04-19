import static board.Marker.CROSS;
import static board.Marker.NOUGHT;
import static gameplay.GameState.DRAWN;
import static gameplay.GameState.WON_BY_CROSSES;
import static position.Position.at;

import exception.WrongPlayException;
import org.junit.Test;
import position.Column;
import position.Row;

public class TicTacGameShouldDrawWhen {


  @Test
  public void whenGameHasEndedAsDraw() throws WrongPlayException {


    new TicTacGame()
        .play(CROSS, at(Row.ONE, Column.ONE))
        .play(NOUGHT, at(Row.ONE, Column.TWO))
        .play(CROSS, at(Row.ONE, Column.THREE))

        .play(NOUGHT, at(Row.TWO, Column.ONE))
        .play(CROSS, at(Row.TWO, Column.THREE))
        .play(NOUGHT, at(Row.TWO, Column.TWO))

        .play(CROSS, at(Row.THREE, Column.ONE))
        .play(NOUGHT, at(Row.THREE, Column.THREE))
        .play(CROSS, at(Row.THREE, Column.TWO))
        .assertThatGameIs(DRAWN);

  }
}
