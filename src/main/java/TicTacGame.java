public class TicTacGame {

    State[] grid = new State[10];

    public void playerMove(int i) throws PositionAlreadyOccupiedException {

        move(State.PLAYER, i);
    }

    public State checkState(int i) {
        return grid[i];
    }

    public void computerMove(int i) throws PositionAlreadyOccupiedException{

        move(State.COMPUTER, i);
    }

    private void move(State state, int i) throws PositionAlreadyOccupiedException{
        if (grid[i] != null) {
            throw new PositionAlreadyOccupiedException();
        }
        grid[i] = state;
    }

    public String checkOutcome() {
        if(grid[2] == grid[5] && grid[5] == grid[8])
            return grid[2].getWinningOutcome();
        else if(grid[1] == grid[5] && grid[5] == grid[9])
            return grid[1].getWinningOutcome();
        else if(grid[3] == grid[5] && grid[5] == grid[7])
            return grid[3].getWinningOutcome();
        return State.PLAYER.getWinningOutcome();
    }
}
