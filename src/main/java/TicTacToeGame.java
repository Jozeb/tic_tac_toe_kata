public class TicTacToeGame {
    Player player1;
    Player player2;
    int moveCount;
    String [][] board = new String[3][3];

    public TicTacToeGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return (isPlayer1Turn())?player1:player2;
    }

    public boolean isPlayer1Turn() {
        return moveCount % 2 == 0;
    }

    public int getMoveCount() {
        return moveCount;
    }


    public String getMarkerAt(int i, int i1) {

    }
}
