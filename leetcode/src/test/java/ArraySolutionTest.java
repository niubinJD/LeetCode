import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySolutionTest {

    @Test
    void pivotIndex() {
        assert ArraySolution.pivotIndex(new int[]{1, 2, 3}) == -1;
        assert ArraySolution.pivotIndex(new int[]{1, 5, 3, 2, 4}) == -1;

    }

    @Test
    void dominantIndex() {
        assert ArraySolution.dominantIndex(new int[]{1, 2, 3, 4}) == -1;
        assert ArraySolution.dominantIndex(new int[]{1, 2, 4}) == 2;
    }

    @Test
    void plusOne() {
        assertArrayEquals(new int[]{1, 0 ,0}, ArraySolution.plusOne(new int[]{9, 9}));
    }

    @Test
    void findDiagonalOrder() {
    }


}