import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    Player player1;
    Player player2;
    int moveCount;
    String [][] board = new String[3][3];

    public TicTacToeGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = "";
            }
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return (isPlayer1Turn()) ? player1 : player2;
    }

    public boolean isPlayer1Turn() {
        return moveCount % 2 == 0;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean isGameFinished() {
        return false;
    }

    public String getMarkerAt(int i, int j) {
        return board[i][j];
    }

    public void nextMove() {
        if (isGameFinished()) {
            throw new AssertionError("Game has ended, cannot perform nextMove()");
        }

        List<Pair<Integer, Integer>> validMoves = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j].equals("")) {
                    validMoves.add(new Pair<>(i, j));
                }
            }
        }

        Player player = getCurrentPlayer();
        Pair<Integer, Integer> move = player.pickMove(validMoves);

        if (board[move.getKey()][move.getValue()].equals("")) {
            // Perform game state changes
            board[move.getKey()][move.getValue()] = player.getMarker();
            moveCount += 1;

        } else {
            throw new AssertionError("Invalid Move Picked!");
        }
    }
}
