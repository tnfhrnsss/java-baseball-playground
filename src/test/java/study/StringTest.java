package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest() {
        String[] nums = "1,2".split(",");
        assertThat(nums).contains("1");
        assertThat(nums).containsExactly(new String[]{"1","2"});
    }

    @Test
    void subStringTest() {
        String nums = "(1,2)";
        String newnums = nums.substring(1,3);
        System.out.println(newnums);
        //assertThat(newnums).isEqualTo("1,2");
    }
}
