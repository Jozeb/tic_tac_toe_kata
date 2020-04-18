package board;

public class FirstCross {
    boolean value = false;

    public void play() {
        value = true;
    }

    public boolean played() {
        return value;
    }
}
