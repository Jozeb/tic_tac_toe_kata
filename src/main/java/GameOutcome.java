public enum GameOutcome {
    PLAYER_WON("Player Won"),
    PLAYER_LOST("Player Lost"),
    MATCH_DRAW("Match Draw");

    private String outcomeResult;

    GameOutcome(String outcomeResult) {
        this.outcomeResult = outcomeResult;
    }

    public String getOutcomeResult() {
        return outcomeResult;
    }
}
