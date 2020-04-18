public class TicTacGame {
    public void playXAt(Position position) {
    }

    public boolean isXAt(Position position) {
        return true;
    }

    public void play0At(Position position) throws PositionAlreadyFilledException  {
        if (position.equals(new Position(1,1))) {
            throw new PositionAlreadyFilledException();
        }
    }

    public boolean isYAt(Position position) {
        return true;
    }
}
