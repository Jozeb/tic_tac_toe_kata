

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class TicTacGame {

    boolean isFirstMove = true;

    boolean isPlayer1Turn = true;

    int[][] board = new int[3][3];
    Map<Integer, Pair<Integer, Integer>> mapper;

    TicTacGame() {
        mapper = new HashMap<Integer, Pair<Integer, Integer>>();
        int counter = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mapper.put(counter++, Pair.with(i, j));
            }
        }

    }


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
        Pair<Integer, Integer> coordinates = mapper.get(move);
        board[coordinates.getValue0()][coordinates.getValue1()] = player;
    }

    private void checkPositionOccupied(int move) throws Exception {
        Pair<Integer, Integer> coordinates = mapper.get(move);
        if (board[coordinates.getValue0()][coordinates.getValue1()] != 0)
            throw new Exception();
    }


}
