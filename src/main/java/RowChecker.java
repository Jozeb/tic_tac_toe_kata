import java.util.List;

public class RowChecker implements Checker {
    @Override
    public boolean check(List<Integer> moves) {
        return ((moves.contains(1) && moves.contains(2) && moves.contains(3))
                || moves.contains(4) && moves.contains(5) && moves.contains(6)
                || moves.contains(7) && moves.contains(8) && moves.contains(9));
    }
}
