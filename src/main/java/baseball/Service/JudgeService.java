package baseball.Service;

import baseball.Constant.Message;
import baseball.Domain.BaseBallNumber;

public class JudgeService {

    public String result(CompareService compareService, BaseBallNumber baseallNumber) {
        int total = compareService.countTotal(baseallNumber).getTotal();
        int strike = compareService.countStrike(baseallNumber).getStrike();
        int ball = total - strike;

        if(total == 0) return Message.BB_GAME_MSG_NOTHING;
        if(strike == 0) return ball + Message.BB_GAME_MSG_BALL;
        if(ball == 0) return strike + Message.BB_GAME_MSG_STRIKE;

        return ball + Message.BB_GAME_MSG_BALL + " " + strike + Message.BB_GAME_MSG_STRIKE;
    }
}
