import javafx.util.Pair;

import java.util.List;

public abstract class Player {
    String marker;

    public Player(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }

    public abstract Pair<Integer, Integer> pickMove(List<Pair<Integer, Integer>> validMoves);
}
