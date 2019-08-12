import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 双指针操作
 */
public class PointSolution {
    /**
     * 反转字符串
     * @param s
     */
    public static void reverseString(char[] s) {
        int leftIndex = 0,rightIndex = s.length - 1; // 5 ,6
        for (int i = 0, len = s.length / 2; i < len; i++) {
            char temp = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = temp;
            rightIndex--;
            leftIndex++;
        }
    }

    /**
     * 数组拆分
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        int[] ints = Arrays.stream(nums).sorted().toArray();
        int index = 0, sum = 0;
        while (index < ints.length) {
            sum += ints[index];
            index += 2;
        }
        return sum;
    }

    /**
     * 两数之和
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int firstIndex = 0, secondIndex = 0;
        over:
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) continue;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    firstIndex = i;
                    secondIndex = j;
                    break over;
                }
            }
        }
        return new int[]{firstIndex + 1, secondIndex + 1};
    }

    /**
     * 移除数组元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int removeIndex = 0, lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {

            if (i > lastIndex) break;

            if (nums[i] != val) continue;

            for (int j = 0; j < lastIndex; j++) {

            }
        }
        return 0;
    }

}
