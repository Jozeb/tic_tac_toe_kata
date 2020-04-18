import java.util.*;

public class TicTacGame {

    private final List<Integer> playerMoves;
    private final List<Integer> computerMoves;

    public TicTacGame(List<Integer> playerMoves, List<Integer> computerMoves) throws OverlappingException {
        this.playerMoves = playerMoves;
        this.computerMoves = computerMoves;

        Set<Integer> checkForOverlapping = new HashSet<>();

        for (int i = 0; i < playerMoves.size(); i++) {
            if (checkForOverlapping.contains(playerMoves.get(i))) {
                throw new OverlappingException();
            }
            checkForOverlapping.add(playerMoves.get(i));
        }

        for (int i = 0; i < computerMoves.size(); i++) {
            if (checkForOverlapping.contains(computerMoves.get(i))) {
                throw new OverlappingException();
            }
            checkForOverlapping.add(computerMoves.get(i));
        }
    }
}
