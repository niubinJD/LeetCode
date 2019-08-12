import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSolutionTest {

    @Test
    void addBinary() {
        assertSame("10101", StringSolution.addBinary("1010", "1011"));
    }

    @Test
    void strStr() {
        assertSame(1, StringSolution.strStr("als", "ls"));
    }

    @Test
    void longestCommonPrefix() {
        assertSame("as", StringSolution.longestCommonPrefix(new String[]{"as", "asd", "asdg"}));
    }
}