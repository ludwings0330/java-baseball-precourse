package baseball;

public interface GameNumberChecker {
    boolean isValidGameNumber(int checkNumber);
    boolean isValidGameNumber(String gameNumber);
    void setGameMode(GameCode code);
}
