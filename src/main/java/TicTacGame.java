import board.Board;
import board.Marker;
import board.Position;

public class TicTacGame {

    Board board = new Board();

    public void play(Marker cross, Position position) throws PositionAlreadyFilledException {
        if (board.contains(position)) {
            throw new PositionAlreadyFilledException();
        }
        board.add(position);
    }

    public boolean is(Marker cross, Position position) {
        return true;
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
