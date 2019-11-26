package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StartSolution {
    /**
     * 只出现一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            boolean hasSame = false;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    hasSame = true;
                    break;
                }
            }
            if (!hasSame) {
                index = i;
            }
        }
        return nums[index];
    }

    /**
     * 求众数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int baseLen = nums.length / 2;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.putIfAbsent(nums[i], 0);
            count.computeIfPresent(nums[i], (key, value) -> value + 1);
        }
        int num = 0;
        for (Map.Entry<Integer, Integer> next : count.entrySet()) {
            if (next.getValue() > baseLen) {
                num = next.getKey();
                break;
            }
        }
        return num;
    }

    /**
     * 搜索二维矩阵 II
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean has = false;
        over:
        for (int i = 0; i < matrix.length; i++) {
            int len = matrix[i].length;
            if (len == 0) {
                continue;
            }
            if (matrix[i][0] > target) {
                continue ;
            }
            if (matrix[i][len - 1] < target) {
                continue ;
            }
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == target) {
                    has = true;
                    break over;
                }
            }
        }
        return has;

    }

    /**
     * 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            int index = m + i;
            nums1[index] = nums2[i];
            adjustAry(nums1, index, nums1[index]);
        }
    }

    private void adjustAry(int[] arr, int index, int val) {
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] <= val) {
                break;
            }
            // >时
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            index = i;
        }
    }


    public int superEggDrop(int K, int N) {
        return 0;
    }

    public int superEggDropHelper(int K, int N, int time) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(7 / 2);
    }
}
