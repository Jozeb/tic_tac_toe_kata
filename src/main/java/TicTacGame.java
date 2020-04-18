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

    public String checkForRow() {
        return "Player Won";
    }
}
