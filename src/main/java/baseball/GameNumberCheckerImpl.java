package baseball;

public class GameNumberCheckerImpl implements GameNumberChecker {
    private static GameNumberChecker instance;
    GameCode code;

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

        return false;
    }

    private boolean isNumber(String checkNumber) {
        try {
            Integer.parseInt(checkNumber);
        } catch (Exception e) {
            System.out.println("[ERROR] 숫자만 사용할 수 있습니다.");
            return false;
        }

        return true;
    }

    private boolean isOutOfRange(int checkNumber) {
        boolean ret = 100 >= checkNumber || checkNumber >= 999;

        if (code == GameCode.PLAY && ret) {
            System.out.println("[ERROR] 입력 가능한 숫자 범위를 벗어났습니다 (123~987)");
        }

        return ret;
    }

    private boolean hasZero(int checkNumber) {
        boolean ret = false;
        while (checkNumber > 0) {
            if (checkNumber % 10 == 0) {
                ret = true;
                break;
            }
            checkNumber /= 10;
        }

        if (code == GameCode.PLAY && ret) {
            System.out.println("[ERROR] 0은 사용할 수 없는 숫자입니다.");
        }
        return ret;
    }

    private boolean isDuplicated(int checkNumber) {
        int first = checkNumber / 100;
        int second = (checkNumber / 10) % 10;
        int third = checkNumber % 10;

        boolean ret = first == second || second == third || third == first;

        if (code == GameCode.PLAY && ret) {
            System.out.println("[ERROR] 중복된 숫자가 존재합니다.");
        }

        return ret;
    }

    private GameNumberCheckerImpl() {
        code = GameCode.READY;
    }

    public static GameNumberChecker getInstance() {
        if (instance == null) {
            instance = new GameNumberCheckerImpl();
        }

        return instance;
    }

    @Override
    public void setGameMode(GameCode code) {
        this.code = code;
    }
}
