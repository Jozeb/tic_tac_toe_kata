import javafx.util.Pair;

import java.util.List;

public class TestComputerPlayer extends Player {

    List<Pair<Integer, Integer>> moves;
    int movePointer = 0;

    public TestComputerPlayer(String marker, List<Pair<Integer, Integer>> moves) {
        super(marker);
        this.moves = moves;
    }

    @Override
    public Pair<Integer, Integer> pickMove(List<Pair<Integer, Integer>> validMoves) {
        movePointer += 1;
        return moves.get(movePointer - 1);
    }
}
