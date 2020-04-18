public class TestComputerPlayer extends Player {
    int[] moves;
    int movePointer = 0;
    public TestComputerPlayer(String marker, int[] moves) {
        super(marker);
        this.moves=moves;
    }
}
