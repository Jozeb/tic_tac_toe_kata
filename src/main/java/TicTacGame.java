package com.game.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacGame {

  private List<Character> board = new ArrayList<>(9);

  public TicTacGame() {
    board = Arrays.asList('-', '-', '-', '-', '-', '-', '-', '-', '-');
  }

  public void playerMove(int gridNo, Character playerMark) {
    int index = gridNo - 1;
    board.set(index, playerMark);
  }

  public List<Character> getBoard() {
    return board;
  }
}
