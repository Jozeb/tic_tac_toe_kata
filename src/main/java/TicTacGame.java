public class TicTacGame {
    public void playXAt(int row, int column) {
    }

    public boolean isXAt(int row, int column) {
        return true;
    }

    public void play0At(int row, int column) throws PositionAlreadyFilledException  {
        throw new PositionAlreadyFilledException();
    }
}
