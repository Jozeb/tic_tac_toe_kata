import java.util.*;

public class TicTacGame {

    private final List<Integer> playerMoves;
    private final List<Integer> computerMoves;

    public TicTacGame(List<Integer> playerMoves, List<Integer> computerMoves) {
        this.playerMoves = playerMoves;
        this.computerMoves = computerMoves;

        throwExceptionIfOverlappingMoves(playerMoves, computerMoves);
    }

    private void throwExceptionIfOverlappingMoves(List<Integer> playerMoves, List<Integer> computerMoves) {
        Set<Integer> uniqueMoves = new HashSet<>();

        uniqueMoves.addAll(playerMoves);
        uniqueMoves.addAll(computerMoves);

        if (uniqueMoves.size() != playerMoves.size() + computerMoves.size()) {
            throw new OverlappingException();
        }
    }

    public GameOutcome checkForRow() {
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

            GameOutcome gameOutcome = intermediateGameOutComeForRow(intermediatePlayerMoves, intermediateComputerMoves);
            if (gameOutcome != GameOutcome.MATCH_DRAW) {
                return gameOutcome;
            }

            isPlayerMove = !isPlayerMove;
        }

        return GameOutcome.MATCH_DRAW;
    }

    private GameOutcome intermediateGameOutComeForRow(List<Integer> playerMoves, List<Integer> computerMoves) {
        if (isRowWin(playerMoves)) return GameOutcome.PLAYER_WON;
        else if (isRowWin(computerMoves)) return GameOutcome.PLAYER_LOST;
        return GameOutcome.MATCH_DRAW;
    }

    private boolean isRowWin(List<Integer> moves) {
        return ((moves.contains(1) && moves.contains(2) && moves.contains(3))
                || moves.contains(4) && moves.contains(5) && moves.contains(6)
                || moves.contains(7) && moves.contains(8) && moves.contains(9));
    }
}
