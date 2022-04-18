package test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudyTest {

    @Test
    void 문자분리테스트(){
        Study study = new Study();

        assertThat (study.splitTest("1,2")) .containsExactly("1", "2");
//        assertThat (study.splitTest("1")) .containsExactly("1");
    }

    @Test
    void 부분문자테스트(){
        Study study = new Study();

        assertThat (study.substringTest("(1,2)")) .isEqualTo("1,2");
    }

    @Test
    @DisplayName("requirements3")
    void req3() {
        assertThatThrownBy(() -> {
            String value = "abc";
            value.charAt(0);
            value.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }


}
