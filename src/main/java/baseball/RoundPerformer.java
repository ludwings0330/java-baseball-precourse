package baseball;

import nextstep.utils.Console;

public class RoundPerformer {
    private final GameNumberChecker gameNumberChecker = GameNumberCheckerImpl.getInstance();

    private final int gameNumber;
    private int inputNumber;
    private int strike;
    private int ball;

    public RoundPerformer(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public void roundStart() {
        do {
            inputNumber = getPlayerInput();

            strike = countStrike();
            ball = countBall();
        } while(!isGameOver());
    }

    private int getPlayerInput() {
        String playerInput = "";

        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerInput = Console.readLine();
        } while (!gameNumberChecker.isValidGameNumber(playerInput));

        return Integer.parseInt(playerInput);
    }

    private int countStrike() {
        int ret = 0;
        int tmpGameNumber = gameNumber;
        int tmpInputNumber = inputNumber;

        while (tmpGameNumber > 0) {
            ret += (tmpGameNumber % 10 == tmpInputNumber % 10) ? 1 : 0;

            tmpGameNumber /= 10;
            tmpInputNumber /= 10;
        }

        return ret;
    }

    private int countBall() {
        int numberOfMatches = 0;
        int tmpGameNumber = gameNumber;

        while (tmpGameNumber > 0) {
            int n = tmpGameNumber % 10;

            numberOfMatches += (n == inputNumber % 10 || n == inputNumber / 10 % 10 || n == inputNumber / 100) ? 1 : 0;
            tmpGameNumber /= 10;
        }

        return numberOfMatches - strike;
    }

    private boolean isGameOver() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return true;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }

        System.out.println(strike + "스트라이크 " + ball + "볼");
        return false;
    }
}
