package baseball;

import nextstep.utils.Console;

public class BaseBallGame {
    private final int RANGE_START = 123;
    private final int RANGE_END = 987;

    private final GameNumberCreator gameNumberCreator;
    private final GameNumberChecker gameNumberChecker;

    public BaseBallGame() {
        this.gameNumberCreator = new RandomGameNumberCreatorImpl();
        this.gameNumberChecker = GameNumberCheckerImpl.getInstance();
    }

    public void start() {
        do {
            play();
        } while (askRestart());
    }

    private void play() {
        int gameNumber = gameNumberCreator.createGameNumber();
        RoundPerformer roundPerformer = new RoundPerformer(gameNumber);

        roundPerformer.roundStart();
    }

    private boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String playerInput = Console.readLine();

        return playerInput.equals(GameCode.RESTART.getCode());
    }

    private int getPlayerInputNumber() {
        String playerInput = "";

        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerInput = Console.readLine();
        } while (!gameNumberChecker.isValidGameNumber(playerInput));

        return Integer.parseInt(playerInput);
    }
}
