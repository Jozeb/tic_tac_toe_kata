public class TicTacGame {
    public void playXAt(Position position) {
    }

    public boolean isXAt(Position position) {
        return true;
    }

    public void play0At(Position position) throws PositionAlreadyFilledException  {
        throw new PositionAlreadyFilledException();
    }

    static class Position {
        private final int row;
        private final int column;

        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}
