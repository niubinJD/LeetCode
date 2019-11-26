package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProblemSolutionTest {
    StringProblemSolution solution = new StringProblemSolution();

    @Test
    void isPalindrome() {
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        assert palindrome;

        boolean palindrome1 = solution.isPalindrome("race a car");
        assert !palindrome1;
    }
}