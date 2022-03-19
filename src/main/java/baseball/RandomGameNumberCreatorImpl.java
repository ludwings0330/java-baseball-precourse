package baseball;

import nextstep.utils.Randoms;

public class RandomGameNumberCreatorImpl implements GameNumberCreator {
    private final GameNumberChecker gameNumberChecker;

    public RandomGameNumberCreatorImpl() {
        this.gameNumberChecker = GameNumberCheckerImpl.getInstance();
    }

    @Override
    public int createGameNumber() {
        int pickedNumber;
        final int RANGE_START = 123;
        final int RANGE_END = 987;

        gameNumberChecker.setGameMode(GameCode.READY);

        do {
            pickedNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
        } while (!gameNumberChecker.isValidGameNumber(pickedNumber));

        gameNumberChecker.setGameMode(GameCode.PLAY);

        return pickedNumber;
    }
}
