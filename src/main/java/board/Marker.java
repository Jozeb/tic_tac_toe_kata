package board;

public enum Marker {
    CROSS, NOUGHT, EMPTY;

    public boolean isNotEmpty() {
        return EMPTY != this;
    }
}
