import java.util.*;
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

    /**
     * 螺旋数组
     *
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int h = matrix.length,w = matrix[0].length,hs = 0, ws = 0, time = 0;
        int fx = 0; // 0 = left 1 = down 2 = right 3 = up
        List<Integer> list = new ArrayList<>();
        for (int i = 0, len = h * w; i < len; i++) {
            System.out.println(ws+ "," + hs+","+fx+","+h + "," + list.size());
            list.add(matrix[hs][ws]);
            if(fx == 0) { // 左方向
                if (ws + 1 >= w) {
                    fx = 1;
                    hs++;
                    continue;
                }
                ws++;
                continue;
            }
            if (fx == 1) { // 下方向
                if (hs + 1 >= h) {
                    fx = 2;
                    ws--;
                    continue;
                }
                hs++;
                continue;
            }

            if (fx == 2) { // 向右
                if (ws <= time) {
                    fx = 3;
                    hs--;
                    continue;
                }
                ws--;
                continue;
            }

            if (fx == 3) {
                if (hs - 1 <= time) {
                    time++;
                    if(h < 2){
                        h = h - 2;
                    }
                    w = w - 2;
                    ws = time;
                    hs = time;
                    fx = 0;
                    continue;
                }
                hs--;
                continue;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            matrix[i] = new int[]{1,2,3,4,5,6,7,8,9,10};
        }
//        matrix[0] = new int[]{1,2,3};
//        matrix[1] = new int[]{10,11,4};
//        matrix[2] = new int[]{9,12,5};
//        matrix[3] = new int[]{8,7,6};
        spiralOrder(matrix).stream().forEach(x -> System.out.println(x));
    }
}
