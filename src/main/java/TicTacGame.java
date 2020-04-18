package com.game.tictactoe;

import exceptions.IllegalMoveException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacGame {

    private List<Character> board = new ArrayList<>(9);
    private Character lastMove;

    public TicTacGame() {
        board = Arrays.asList('-', '-', '-', '-', '-', '-', '-', '-', '-');
    }

    private Character playerX = 'X';
    private Character playerO = 'O';


    public void playerMove(int gridNo, Character playerMark) throws IllegalMoveException {
        int index = gridNo - 1;
        checkPlayerIllegalMoves(playerMark);
        board.set(index, playerMark);
        lastMove = playerMark;
    }

    private void checkPlayerIllegalMoves(Character playerMark) throws IllegalMoveException {
        if (unknownPlayerMove(playerMark)) {
            throw new IllegalMoveException("Illegal move:Unknown player made a move");
        } else if (samePlayerIllegalMoves(playerMark)) {
            throw new IllegalMoveException("Illegal move:same player made a move  twice in a row");
        }
    }

    private boolean samePlayerIllegalMoves(Character playerMark) {
        return lastMove == playerMark;
    }

    private boolean unknownPlayerMove(Character playerMark) {
        return playerMark != playerX && playerMark != playerO;
    }

    public List<Character> getBoard() {
        return board;
    }
}
