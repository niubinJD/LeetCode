import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();
    @Test
    void reverseString() {
        char[] chars = {'a', 'b', 'v', 'q'};
        solution.reverseString(chars);
        assertArrayEquals(new char[]{'q', 'v', 'b', 'a'}, chars);
    }

    @Test
    void removeDuplicates() {
        int[] nums = {1, 1, 2, 3, 4, 4};
        int i = solution.removeDuplicates(nums);
        assert i == 4;
        assertArrayEquals(new int[]{1, 2, 3, 4, 1, 4}, nums);
    }

    @Test
    void removeElement() {
        int[] ints = {3, 2, 2, 3};
        int i = solution.removeElement(ints, 3);
        assert i == 2;
        assertArrayEquals(new int[]{2, 2, 3, 3}, ints);
    }

    @Test
    void searchInsert() {
        int i = solution.searchInsert(new int[]{1, 3, 5, 6}, 0);
        assert i == 0;
    }

    @Test
    void countAndSay() {
        String s = solution.countAndSay(4);
        assertSame("1211", s);
    }

    @Test
    void maxSubArray() {
        int i = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assert i == 6;
    }

    @Test
    void lengthOfLastWord() {
        int i = solution.lengthOfLastWord(" ");
        assert i == 0;
    }

    @Test
    void mySqrt() {
        int i = solution.mySqrt(8);
        assert i == 2;
    }

    @Test
    void climbStairs() {
        int i = solution.climbStairs(44);
        System.out.println(i);
    }
}