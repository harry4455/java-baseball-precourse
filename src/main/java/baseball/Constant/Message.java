package baseball.Constant;

public class Message {

    public final static String BB_GAME_MSG_INPUT = "숫자를 입력해 주세요 : ";
    public final static String BB_GAME_MSG_OUT_RANGE = "숫자를 잘못 입력했습니다. \n";
    public final static String BB_GAME_MSG_NOTHING = "낫싱";
    public final static String BB_GAME_MSG_BALL = "볼";
    public final static String BB_GAME_MSG_STRIKE = "스트라이크";
    public final static String BB_GAME_MSG_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임종료\n";
    public final static String BB_GAME_MSG_REPLAY_ASK = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public final static String BB_GAME_MSG_RESTART = "게임을 다시 시작합니다.\n";
    public final static String BB_GAME_MSG_QUIT = "게임을 종료합니다.\n";


    public void printMsg(String msg) {
        System.out.print(msg);
    }
}
