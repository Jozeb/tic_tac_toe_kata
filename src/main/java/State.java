enum State {
    PLAYER("Player Won"),
    COMPUTER("Computer Won");

    String winningOutcome;

    State(String winningOutcome) {
        this.winningOutcome = winningOutcome;
    }

    public String getWinningOutcome() {
        return winningOutcome;
    }
}
