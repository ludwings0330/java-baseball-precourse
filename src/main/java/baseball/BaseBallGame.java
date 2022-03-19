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
            System.out.println("새로운 게임을 시작합니다.");
            play();
        } while (askRestart());

        System.out.println("게임을 종료합니다.");
    }

    private void play() {
        int gameNumber = gameNumberCreator.createGameNumber();
        RoundPerformer roundPerformer = new RoundPerformer(gameNumber);

        roundPerformer.roundStart();
    }

    private boolean askRestart() {
        String playerInput = null;

        do {
            if (playerInput != null) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            playerInput = Console.readLine();
        } while (!playerInput.equals(GameCode.END.getCode()) && !playerInput.equals(GameCode.RESTART.getCode()));

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
