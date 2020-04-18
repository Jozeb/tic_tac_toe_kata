public class TicTacGame {

    State[] grid = new State[10];

    public void playerMove(int i) throws PositionAlreadyOccupiedException {
        if (grid[i] != null) {
            throw new PositionAlreadyOccupiedException();
        }
        grid[i] = State.PLAYER;
    }

    public State checkState(int i) {
        return grid[i];
    }

    public void computerMove(int i) {
        grid[i] = State.COMPUTER;
    }
}
