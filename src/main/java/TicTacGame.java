

public class TicTacGame {

  boolean isFirstMove = true;

  boolean isPlayer1Turn = true;

  int[][] board = new int[3][3];


  public void player2Move(int i) throws Exception {

    if (isFirstMove || isPlayer1Turn) {
      throw new Exception();
    }
    checkPositionOccupied(i);
    applyMove(i, 2);
    isPlayer1Turn = true;
  }

  public void player1Move(int i) throws Exception {
    if (!isPlayer1Turn) {
      throw new Exception();
    }
    checkPositionOccupied(i);
    applyMove(i, 1);

    isFirstMove = false;
    isPlayer1Turn = false;
  }

  public int[][] getBoard() {
    return board;
  }

  private void applyMove(int move, int player) {

    if (move == 1) {
      board[0][0] = player;
    } else if (move == 2) {
      board[0][1] = player;
    } else if (move == 3) {
      board[0][2] = player;
    } else if (move == 4) {
      board[1][0] = player;
    } else if (move == 5) {
      board[1][1] = player;
    } else if (move == 6) {
      board[1][2] = player;
    } else if (move == 7) {
      board[2][0] = player;
    } else if (move == 8) {
      board[2][1] = player;
    } else if (move == 9) {
      board[2][2] = player;
    }

  }

  private void checkPositionOccupied(int move) throws Exception {

    int currentMove = 1;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {


        if (currentMove == move) {
          if (board[i][j] != 0) {
            throw new Exception();
          } else {
            break;
          }
        }
        currentMove++;

      }
    }


  }


}
