package board;

import exception.GameAlreadyEndedException;
import gameplay.GameState;
import gameplay.validators.AllBoardValidators;
import gameplay.validators.BoardValidator;
import gameplay.validators.CrossWinValidator;
import gameplay.validators.DrawValidator;
import gameplay.validators.NoughtWinValidator;
import position.Position;

import java.util.Arrays;
import java.util.List;

import static gameplay.GameState.IN_PROGRESS;

public class StatefulBoard {

    Board board = new Board();
    GameState gameState = GameState.IN_PROGRESS;
    AllBoardValidators allBoardValidators = new AllBoardValidators();

    public void play(Marker marker, Position position) throws GameAlreadyEndedException {
        assertGameNotOver();
        board.add(marker, position);
        updateGameState();
    }

    private void updateGameState() {
        this.gameState = allBoardValidators.validate(board);
    }

    public boolean exists(Marker marker, Position position) {
        return marker == board.whatIsAt(position);
    }

    public boolean isState(GameState gameState) {
        return this.gameState == gameState;
    }

    void assertGameNotOver() throws GameAlreadyEndedException {
        if (this.gameState != GameState.IN_PROGRESS)
            throw new GameAlreadyEndedException();
    }
}
