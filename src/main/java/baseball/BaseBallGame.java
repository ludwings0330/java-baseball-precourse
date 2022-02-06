package baseball;

import nextstep.utils.Randoms;

public class BaseBallGame {
    private final int RANGE_START = 123;
    private final int RANGE_END = 987;

    private int gameNumber;

    public void play() {
        createGameNumber();
        System.out.println("gameNumber is : " + gameNumber);
    }

    public void createGameNumber() {
        int pickedNumber;

        do {
            pickedNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
        } while (!isValidNumber(pickedNumber));

        setGameNumber(pickedNumber);
    }

    public void setGameNumber(int pickedNumber) {
        this.gameNumber = pickedNumber;
    }

    public boolean isValidNumber(int checkNumber) {
        int first = checkNumber / 100;
        int second = (checkNumber / 10) % 10;
        int third = checkNumber % 10;

        if (checkNumber > 999 || first == 0 || second == 0 || third == 0 || first == second || second == third || first == third) {
            return false;
        }

        return true;
    }
}
