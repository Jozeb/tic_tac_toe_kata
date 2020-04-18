public class TicTacGame {
    public void playXAt(Position position) {
    }

    public boolean isXAt(Position position) {
        return true;
    }

    public void play0At(Position position) throws PositionAlreadyFilledException  {
        throw new PositionAlreadyFilledException();
    }
}
