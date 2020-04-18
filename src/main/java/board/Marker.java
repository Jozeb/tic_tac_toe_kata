package board;

public enum Marker {
    CROSS, NOUGHT;

    public boolean isNought() {
        return NOUGHT == this;
    }
}
