public class TicTacGame {

    State[] grid = new State[10];
    State[][] grid2d = new State[3][3];

    public void playerMove(int i) throws PositionAlreadyOccupiedException {

        move(State.PLAYER, i);
    }

    public State checkState(int i) {
        return grid[i];
    }

    public void computerMove(int i) throws PositionAlreadyOccupiedException{

        move(State.COMPUTER, i);
    }

    private void move2d(State state, int i) throws PositionAlreadyOccupiedException {
        int row = (i - 1) / 3;
        int column = (i - 1) % 3;
        if (grid2d[row][column] != null) {
            throw new PositionAlreadyOccupiedException();
        }
        grid2d[row][column] = state;
    }

    private void move(State state, int i) throws PositionAlreadyOccupiedException{
        if (grid[i] != null) {
            throw new PositionAlreadyOccupiedException();
        }
        grid[i] = state;
        move2d(state, i);
    }

    public String checkOutcome2d() {
        for (int i = 0; i < 3; i++) {
            if (grid2d[i][0] == grid2d[i][1] && grid2d[i][1] == grid2d[i][2]) {
                return grid2d[i][0].getWinningOutcome();
            }

            if (grid2d[0][i] == grid2d[1][i] && grid2d[1][i] == grid2d[2][i]) {
                return grid2d[0][i].getWinningOutcome();
            }
        }

        if (grid2d[0][0] == grid2d[1][1] && grid2d[1][1] == grid2d[2][2]) {
            return grid2d[0][0].getWinningOutcome();
        }

        if (grid2d[0][2] == grid2d[1][1] && grid2d[1][1] == grid2d[2][0]) {
            return grid2d[0][2].getWinningOutcome();
        }

        return "Match Draw";
    }

    public String checkOutcome() {
        return checkOutcome2d();
    }
}
