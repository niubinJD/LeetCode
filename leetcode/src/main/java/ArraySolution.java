import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ArraySolution {
    /**
     * 寻找数组的中心索引
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        if (nums.length <= 0) return -1;
        int index = 0;
        boolean flag = true;
        while (flag) {
            int left = 0,right = 0;
            for (int i = 0, len = nums.length; i < len; i++) {
                if (i < index) {
                    left += nums[i];
                }
                if (i > index) {
                    right += nums[i];
                }
            }
            if (left == right) {
                flag = false;
                continue;
            }
            if (index == (nums.length - 1)) {
                flag = false;
                index = -1;
                continue;
            }
            index++;
        }
        return index;
    }

    /**
     * 至少是其他数字两倍的最大数
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        if (nums.length <= 0) return -1;
        int maxIndex = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            if (maxIndex == i) {
                continue;
            }
            if (nums[i] == 0) {
                continue;
            }
            if (nums[maxIndex] / nums[i] < 2) {
                maxIndex = -1;
                break;
            }
        }
        return maxIndex;
    }

    /**
     * 加一
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        digits[ digits.length - 1 ] += 1;
        int nextAddNum = 0;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i] += nextAddNum;
            if (digits[i] >= 10) {
                nextAddNum = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }else {
                nextAddNum = 0;
            }
        }
        if (nextAddNum > 0) {
            int[] ints = Arrays.copyOf(digits, digits.length + 1);
            ints[ints.length - 1] = 1;
            for (int i = ints.length - 1; i >= 0 ; i--) {

                if (i == 0) {
                    ints[i] = nextAddNum;
                    continue;
                }
                ints[i] = ints[i - 1];
            }
            return ints;
        }

        return digits;
    }

    /**
     * 对角线遍历
     *
     *
     *      1 2 9 8 8
     *      2 3 2 8 8
     *      9 9 9 8 8
     *      9 9 9 9 8
      *
     *      max =
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length,
                column = matrix[0].length,
                rowIndex = 0,
                columnIndex = 0;
        int[] print = new int[row * column];
        return print;
    }
}
