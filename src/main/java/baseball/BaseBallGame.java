package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class BaseBallGame {
    private final int RANGE_START = 123;
    private final int RANGE_END = 987;
    private final String RESTART = "1";
    private int gameNumber;



    public void play() {
        do {
            int playerInputNumber = getPlayerInputNumber();
            System.out.println("playerInputNumber = " + playerInputNumber);
        } while (true);

    }

    private int getPlayerInputNumber() {
        String playerInput = "";

        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerInput = Console.readLine();
        } while (!isValidPlayerInput(playerInput));

        return Integer.parseInt(playerInput);
    }

    private boolean isValidPlayerInput(String playerInput) {
        if (!isNumber(playerInput)) {
            return false;
        }

        if (!isValidNumber(Integer.parseInt(playerInput))) {
            System.out.println("ERROR : 올바른 숫자를 입력해주세요 ");
            return false;
        }

        return true;
    }

    private boolean isNumber(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (Exception e) {
            System.out.println("ERROR : 숫자를 입력해주세요");
            return false;
        }

        return true;
    }

    public void start() {

        do {
            setGameNumber(createGameNumber());
            System.out.println("gameNumber is : " + gameNumber);

            play();

        } while (confirmRestart());
    }

    private boolean confirmRestart() {
        System.out.println("게임르 새로 시작하려 1, 종료하려면 2를 입력하세요.");

        String playerInput = Console.readLine();

        return playerInput.equals(RESTART) ? true : false;
    }

    public int createGameNumber() {
        int pickedNumber;

        do {
            pickedNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
        } while (!isValidNumber(pickedNumber));

        return pickedNumber;
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
