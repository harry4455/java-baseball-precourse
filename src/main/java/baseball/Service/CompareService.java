package baseball.Service;

import baseball.Domain.BaseBallNumber;
import baseball.Domain.Score;

public class CompareService {

    private final BaseBallNumber consoleNum;
    private final BaseBallNumber playerNum;
    private final Score score;

    public CompareService(BaseBallNumber consoleNum, BaseBallNumber playerNum) {
        this.consoleNum = consoleNum;
        this.playerNum = playerNum;

        score = new Score(0, 0);
    }

    public Score countStrike(BaseBallNumber baseballNumber) {
        for (int i = 0; i < baseballNumber.getSize(); i++) {
            int playerNum = baseballNumber.getNumber(i);
            addStrike(playerNum, score);
        }

        return score;
    }

    private void addStrike(int playerDigit, Score score) {
        if (consoleNum.getIndex(playerDigit) == playerNum.getIndex(playerDigit)) {
            score.setStrike(score.getStrike() + 1);
        }
    }

    public Score countTotal(BaseBallNumber baseballNumber) {
        int size = baseballNumber.getSize();
        for(int i=0; i<size; i++) {
            int playerNum = baseballNumber.getNumber(i);
            addTotal(playerNum, score);
        }

        return score;
    }

    private void addTotal(int playerDigit, Score score) {
        if(consoleNum.isExist(playerDigit)) {
            score.setTotal(score.getTotal() + 1);
        }
    }

    public Score getScore() {
        return score;
    }

}