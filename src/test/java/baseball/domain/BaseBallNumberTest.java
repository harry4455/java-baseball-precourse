package baseball.domain;


import baseball.Domain.BaseBallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBallNumberTest {

    @DisplayName("리스트 비교")
    @Test
    void ListCompareTest() {
        BaseBallNumber baseBallNumber = new BaseBallNumber("123");
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals(baseBallNumber.getBaseBallNumberList(), numberList);
    }
}
