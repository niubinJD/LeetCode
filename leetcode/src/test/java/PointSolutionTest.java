import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PointSolutionTest {

    @Test
    void reverseString() {
        char[] chars = {'a','b','d','1','4','7','8'};
        PointSolution.reverseString(chars);
        assertArrayEquals(new char[]{'8','7','4','1','d','b','a'},chars);
    }

    @Test
    void arrayPairSum() {
        System.out.println(PointSolution.arrayPairSum(new int[]{1,4,3,2}));
    }

    @Test
    void twoSum() {
        Arrays.stream(PointSolution.twoSum(new int[]{-1, 0}, -1)).forEach(System.out::println);
    }
}