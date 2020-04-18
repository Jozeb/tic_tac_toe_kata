package board;

public enum Marker {
    CROSS, NOUGHT, EMPTY;

    public boolean isNought() {
        return NOUGHT == this;
    }
}
