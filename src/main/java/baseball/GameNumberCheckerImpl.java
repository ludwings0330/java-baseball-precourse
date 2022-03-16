package baseball;

public class GameNumberCheckerImpl implements GameNumberChecker {
    private static GameNumberChecker instance;
    @Override
    public boolean isValidGameNumber(int checkNumber) {
        int first = checkNumber / 100;
        int second = (checkNumber / 10) % 10;
        int third = checkNumber % 10;

        if (isOutOfRange(checkNumber) || hasZero(checkNumber) || isDuplicated(checkNumber)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isValidGameNumber(String checkNumber) {
        if (isNumber(checkNumber) && isValidGameNumber(Integer.parseInt(checkNumber))) {
            return true;
        }
        System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
        return false;
    }

    private boolean isNumber(String checkNumber) {
        try {
            Integer.parseInt(checkNumber);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private boolean isOutOfRange(int checkNumber) {
        return 100 >= checkNumber || checkNumber >= 999;
    }

    private boolean hasZero(int checkNumber) {
        while (checkNumber > 0) {
            if (checkNumber % 10 == 0) {
                return true;
            }
            checkNumber /= 10;
        }

        return false;
    }

    private boolean isDuplicated(int checkNumber) {
        int first = checkNumber / 100;
        int second = (checkNumber / 10) % 10;
        int third = checkNumber % 10;

        return first == second || second == third || third == first;
    }

    private GameNumberCheckerImpl() {
    }

    public static GameNumberChecker getInstance() {
        if (instance == null) {
            instance = new GameNumberCheckerImpl();
        }

        return instance;
    }
}
