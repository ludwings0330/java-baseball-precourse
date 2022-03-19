package baseball;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GameCode {
    RESTART("1", "게임 재시작"),
    END("2", "게임 종료"),
    READY("3", "게임 준비중"),
    PLAY("4", "게임 진행중");

    private final String code;
    private final String description;
}
