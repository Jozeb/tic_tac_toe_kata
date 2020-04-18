import java.util.*;

public class TicTacGame {

    private final List<Integer> playerMoves;
    private final List<Integer> computerMoves;

    public TicTacGame(List<Integer> playerMoves, List<Integer> computerMoves) throws OverlappingException {
        this.playerMoves = playerMoves;
        this.computerMoves = computerMoves;

        throwExceptionIfOverlappingMoves(playerMoves, computerMoves);
    }

    private void throwExceptionIfOverlappingMoves(List<Integer> playerMoves, List<Integer> computerMoves) throws OverlappingException {
        Set<Integer> uniqueMoves = new HashSet<>();

        uniqueMoves.addAll(playerMoves);
        uniqueMoves.addAll(computerMoves);

        if (uniqueMoves.size() != playerMoves.size() + computerMoves.size()) {
            throw new OverlappingException();
        }
    }
}
