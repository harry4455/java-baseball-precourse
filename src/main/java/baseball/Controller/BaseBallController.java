package baseball.Controller;

import baseball.Constant.Message;
import baseball.Domain.BaseBallNumber;
import baseball.Domain.GameConsole;
import baseball.Domain.Player;
import baseball.Domain.Score;
import baseball.Service.CompareService;
import baseball.Service.JudgeService;
import baseball.View.Input;

public class BaseBallController {
    private static final int REPLAY = 1;
    private static final int QUIT   = 2;
    private static final int STRIKE = 3;

    private static boolean state;
    private static GameConsole gameConsole;
    private static Player player;
    private static Message message;
    private static Score score;
    private static Input input;

    public static void execute() {
        initGame();
        if(state) {
            inputNum();
            printResult();
            chkResult();
        }
    }

    private static void chkResult() {
        if(score.getStrike() == STRIKE) {
            state = false;
            message.printMsg(Message.BB_GAME_MSG_WIN);
            replayChk();
        }
    }

    private static void replayChk() {
        int choice = askReplay();

        if(choice == REPLAY) {
            message.printMsg(Message.BB_GAME_MSG_RESTART);
            execute();
        }

        if(choice == QUIT) {
            message.printMsg(Message.BB_GAME_MSG_QUIT);
            state = true;
        }

    }

    private static int askReplay() {
        message.printMsg(Message.BB_GAME_MSG_REPLAY_ASK);
        try {
            int choice = Integer.parseInt(input.inputNum());
            if(choice != 1 && choice != 2) {
                throw new IllegalArgumentException(Message.BB_GAME_MSG_OUT_RANGE);
            }
            return choice;
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(
                  Message.BB_GAME_MSG_OUT_RANGE
            );
        }
    }

    private static void printResult() {
        CompareService compareService = new CompareService(GameConsole.getGameConsole(), player.getBaseBallNumber());
        score = compareService.getScore();
        JudgeService judgeService = new JudgeService();
        String result = judgeService.result(compareService, player.getBaseBallNumber());
        message.printMsg(result + "\n");
    }

    private static void inputNum() {
        message.printMsg(Message.BB_GAME_MSG_INPUT);
        input = new Input();
        String inputNum = input.inputNum();
        player.setBaseballNumber(new BaseBallNumber(inputNum));

    }

    private static void initGame(){
        state = true;
        gameConsole = new GameConsole();
        player = new Player();
    }
}
