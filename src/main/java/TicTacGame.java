public class TicTacGame {

    State[] grid = new State[10];

    public void playerMove(int i) throws PositionAlreadyOccupiedException {
        if (grid[i] != null) {
            throw new PositionAlreadyOccupiedException();
        }
        move(State.PLAYER, i);
    }

    public State checkState(int i) {
        return grid[i];
    }

    public void computerMove(int i) {
        move(State.COMPUTER, i);
    }

    private void move(State state, int i) {
        grid[i] = state;
    }
}
