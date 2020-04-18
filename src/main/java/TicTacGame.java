public class TicTacGame {
    public void playerMove(int i) {

    }


    public State checkState(int i) {

        if (i == 5){
            return State.PLAYER;
        }

        return State.COMPUTER;
    }

    public void computerMove(int i) {
    }
}
