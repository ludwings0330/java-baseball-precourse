package baseball;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GameCode {
    RESTART("1", "게임 재시작"), END("2", "게임 종료");

    private final String code;
    private final String description;
}
