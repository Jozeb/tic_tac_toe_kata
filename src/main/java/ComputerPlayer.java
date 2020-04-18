import javafx.util.Pair;

import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String marker) {
        super(marker);
    }

    @Override
    public Pair<Integer, Integer> pickMove(List<Pair<Integer, Integer>> validMoves) {
        Random random = new Random();

        int randIndex = random.nextInt() % validMoves.size();
        return validMoves.get(randIndex);
    }
}
