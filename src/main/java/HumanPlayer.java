import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String marker) {
        super(marker);
    }

    @Override
    public Pair<Integer, Integer> pickMove(List<Pair<Integer, Integer>> validMoves) {
        System.out.println("Valid moves are: ");
        for (Pair<Integer, Integer> p : validMoves) {
            System.out.print("(" + p.getKey() + ", " + p.getValue() + ") ");
        }

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose index of move you want to perform: ");
        int index = scanner.nextInt();

        return validMoves.get(index);
    }
}
