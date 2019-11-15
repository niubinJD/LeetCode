
public class Solution {
    /**
     * leetcode-344-反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {
        reverseHelper(0, s);
    }

    private void reverseHelper(int index, char[] s) {
        if (s == null || index >= s.length) {
            return;
        }
        char a = s[(s.length - 1) - index];
        reverseHelper(index + 1, s);
        s[index] = a;
    }

    /**
     * leetcode-26-删除排序数组中的重复项
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int len = nums.length;
        int index = 0;
        int same = 0;
        while (index < ((len - same) - 1)) {
            if (nums[index] != nums[index + 1]) {
                index++;
                continue;
            }
            // 调整数组， 每调整一次代表着，重复者多一个
            adjustHelper(nums, index + 1);
            same++;
        }
        return len - same;
    }

    private void adjustHelper(int[] nums, int start) {
        int a = nums[start];
        while (start < nums.length - 1) {
            nums[start] = nums[start + 1];
            start++;
        }
        nums[nums.length - 1] = a;
    }

    /**
     * leetcode-27-移除元素
     *
     * @param nums
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int len = nums.length;
        int index = 0;
        int same = 0;
        while (index < (len - same)) {
            if (nums[index] != val) {
                index++;
                continue;
            }
            // 调整数组， 每调整一次代表着，重复者多一个
            adjustHelper(nums, index);
            same++;
        }
        return index;
    }

    /**
     * leetcode-35-搜索插入位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        if (nums[startIndex] >= target) {
            return startIndex;
        }
        if (nums[endIndex] < target) {
            return endIndex + 1;
        }
        if (nums[endIndex] == target) {
            return endIndex;
        }
        int bin = (endIndex + startIndex) / 2;
        if (bin == startIndex) {
            return startIndex + 1;
        }
        if (bin == endIndex) {
            return endIndex;
        }
        if (nums[bin] > target) {
            return binarySearch(nums, startIndex, bin, target);
        }
        if (nums[bin] < target) {
            return binarySearch(nums, bin, endIndex, target);
        }
        return bin;
    }

    /**
     * leetcode-38-报数
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        return getStr(null, 1, n);
    }

    private String getStr(String str, int cN, int last) {
        StringBuilder res = new StringBuilder();
        if (str == null || "".equals(str)) {
            res.append(cN);
        } else {
            String[] single = str.split("");
            String curEle = single[0];
            int count = 1;
            for (int i = 1; i < single.length; i++) {
                if (!curEle.equals(single[i])) {
                    res.append(count).append(curEle);
                    curEle = single[i];
                    count = 1;
                    continue;
                }
                count++;
            }
            res.append(count).append(curEle);
        }

        if (cN >= last) {
            return res.toString();
        }
        return getStr(res.toString(), cN + 1, last);
    }

    /**
     * leetcode-53-最大子序和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = maxSubHelper(nums, 0);
        for (int i = 1; i < nums.length; i++) {
            int res = maxSubHelper(nums, i);
            if (max < res) {
                max = res;
            }
        }
        return max;
    }

    private int maxSubHelper(int[] nums, int start) {
        int sum = nums[start];
        int maxSum = nums[start];
        for (int i = start + 1; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    /**
     * leetcode-58-最后一个单词长度
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] str = s.split(" ");
        if (str.length <= 0) {
            return 0;
        }
        return str[str.length - 1].length();
    }

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public int climbStairs(int n) {
        return climbStairsHelper(n);
    }

    private int climbStairsHelper(int lastN){
        if (lastN >= 2) {
            int a = climbStairsHelper(lastN - 1);
            int b = climbStairsHelper(lastN - 2);
            return a + b;
        }
        if (lastN == 1) {
            return climbStairsHelper(lastN - 1);
        }
        return 1;
    }

}
