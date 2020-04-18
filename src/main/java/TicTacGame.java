public class TicTacGame {

  boolean isFirstMove = true;

  boolean isPlayer1Turn = true;

  int [][] board = new int[3][3];



  public void player2Move(int i) throws Exception {

    if (isFirstMove || isPlayer1Turn) {
      throw new Exception();
    }

    isPlayer1Turn = true;
  }

  public void player1Move(int i) throws Exception {
    if (!isPlayer1Turn) {
      throw new Exception();
    }
    isFirstMove = false;
    isPlayer1Turn = false;
  }

    public int[][] getBoard() {
        return board;
    }
}
