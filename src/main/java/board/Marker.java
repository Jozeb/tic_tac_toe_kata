package board;

public enum Marker {
    CROSS, NOUGHT, EMPTY;

    public boolean isEmpty() {
        return EMPTY == this;
    }
}
