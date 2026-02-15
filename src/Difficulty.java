public enum Difficulty {
    EASY(10),
    MEDIUM(5),
    HARD(3);

    private final int attempts;

    Difficulty(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }
}
