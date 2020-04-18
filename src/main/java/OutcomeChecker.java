import java.util.ArrayList;
import java.util.List;

public class OutcomeChecker {

    List<Checker> checkers;

    OutcomeChecker(List<Checker> checkers) {
        this.checkers = checkers;
    }

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

        for (int i = 0; i < checkers.size(); i++) {
            Checker checker = checkers.get(i);

            if (checker.check(playerMoves)) return GameOutcome.PLAYER_WON;
            else if (checker.check(computerMoves)) return GameOutcome.PLAYER_LOST;
        }

        return GameOutcome.MATCH_DRAW;
    }
}
