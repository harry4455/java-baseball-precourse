package baseball.Domain;

import baseball.Constant.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaseBallNumber {

    private List<Integer> numList;

    public BaseBallNumber() {
        this.numList = new ArrayList<>();
    }

    public BaseBallNumber(String input) {
        this.numList = new ArrayList<>();
        if(validate(input)) {
            this.numList = storeInput(input);
        }
    }

    private List<Integer> storeInput(String input) {
        int inputNum = Integer.parseInt(input);
        numToList(inputNum);

        return numList;
    }

    private void numToList(int inputNum) {
        String[] inputNumArr = String.valueOf(inputNum).split("");
        for(String num : inputNumArr) {
            int number = Integer.parseInt(num);
            isValid(number);
            numList.add(number);
        }
    }

    private void isValid(int number) {
        if(numList.contains(number)) {
            throw new IllegalArgumentException(Message.BB_GAME_MSG_OUT_RANGE);
        }
    }

    private boolean validate(String input) {
        String regex = "^[1-9]{3}$";
        if(!Pattern.matches(input, regex)) {
            throw new IllegalArgumentException(Message.BB_GAME_MSG_OUT_RANGE);
        }
        return true;
    }

    public int getSize() {
        return numList.size();
    }

    public int getNumber(int idx) {
        return numList.get(idx);
    }

    public int getIndex(int num) {
        return numList.indexOf(num);
    }

    public boolean isExist(int num) {
        return numList.contains(num);
    }

    public List<Integer> getBaseBallNumberList(){
        return numList;
    }
}
