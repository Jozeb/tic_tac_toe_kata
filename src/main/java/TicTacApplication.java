public class TicTacApplication {


  public static void main(String[] args) {
    int[] player1Moves = {2,3,5,1,6,7,8};
    int[] computerMoves = {2,3,5,1,6,7,8};




    TicTacGame ticTacGame = new TicTacGame();
    ticTacGame.playGame(player1Moves, computerMoves);
  }

}
