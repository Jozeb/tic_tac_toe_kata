import java.util.ArrayList;
import java.util.List;

public abstract class OutcomeChecker {
    public GameOutcome check(List<Integer> playerMoves, List<Integer> computerMoves) {

        List<Integer> intermediatePlayerMoves = new ArrayList<>();
        List<Integer> intermediateComputerMoves = new ArrayList<>();

        boolean isPlayerMove = true;
        int playerMoveIndex = 0, computerMoveIndex = 0;

        while ((playerMoveIndex < playerMoves.size() && isPlayerMove) || (computerMoveIndex < computerMoves.size() && !isPlayerMove)) {
            if (isPlayerMove) {
                intermediatePlayerMoves.add(playerMoves.get(playerMoveIndex));
                playerMoveIndex++;
            } else {
                intermediateComputerMoves.add(computerMoves.get(computerMoveIndex));
                computerMoveIndex++;
            }

            GameOutcome gameOutcome = intermediateGameOutComeCheck(intermediatePlayerMoves, intermediateComputerMoves);
            if (gameOutcome != GameOutcome.MATCH_DRAW) {
                return gameOutcome;
            }

            isPlayerMove = !isPlayerMove;
        }

        return GameOutcome.MATCH_DRAW;
    }

    private GameOutcome intermediateGameOutComeCheck(List<Integer> playerMoves, List<Integer> computerMoves) {
        if (this.specificCheck(playerMoves)) return GameOutcome.PLAYER_WON;
        else if (this.specificCheck(computerMoves)) return GameOutcome.PLAYER_LOST;
        return GameOutcome.MATCH_DRAW;
    }

    protected abstract boolean specificCheck(List<Integer> moves);
}
