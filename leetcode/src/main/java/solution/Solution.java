package solution;

import assist.ListNode;
import assist.TreeNode;

import java.util.*;

public class Solution {
    /**
     * leetcode-344-反转字符串
     *
     * @param s .
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
     * @param nums .
     * @return .
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
     * @param nums .
     * @return .
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
     * @param nums   .
     * @param target .
     * @return .
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
     * @param n .
     * @return .
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
     * @param nums .
     * @return .
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
     *
     * @param s .
     * @return .
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

    /**
     * 70-爬楼梯
     *
     * @param n .
     * @return .
     */
    public int climbStairs(int n) {
        int[] ints = new int[n + 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = -1;
        }
        return climbStairsHelper(ints, n);
    }

    private int climbStairsHelper(int[] q, int n) {
        if (q[n] > 0) {
            return q[n];
        }
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            q[n] = n;
            return n;
        }
        int i = climbStairsHelper(q, n - 1) + climbStairsHelper(q, n - 2);
        q[n] = i;
        return q[n];
    }

    /**
     * leetcode-83-删除排序链表中的重复元素
     *
     * @param head .
     * @return .
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode rep = head;
        while (rep.next != null) {
            if (rep.val == rep.next.val) {
                rep.next = rep.next.next;
                continue;
            }
            rep = rep.next;
        }
        return head;
    }


    /**
     * leetcode-88-合并两个有序数组
     *
     * @param nums1 .
     * @param m     .
     * @param nums2 .
     * @param n     .
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

    /**
     * leetcode-100-相同的树
     *
     * @param p .
     * @param q .
     * @return .
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return p == q;
    }


    /**
     * leetcode-101-对称二叉树
     *
     * @param root .
     * @return .
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }


    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    /**
     * leetcode-104-二叉树的最大深度
     *
     * @param root .
     * @return .
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + (left > right ? left : right);
    }


    /**
     * leetcode-107-二叉树的层次遍历 II
     *
     * @param root .
     * @return .
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        levelOrderBottomHelper(root, all, 1);
        Collections.reverse(all);
        return all;
    }

    private void levelOrderBottomHelper(TreeNode root, List<List<Integer>> all, int index) {
        if (root == null) {
            return;
        }
        if (all.size() < index) {
            all.add(new ArrayList<>());
        }
        all.get(index - 1).add(root.val);
        levelOrderBottomHelper(root.left, all, index + 1);
        levelOrderBottomHelper(root.right, all, index + 1);

    }

    /**
     * 202-快乐数
     *
     * @param n .
     * @return .
     */
    public boolean isHappy(int n) {
        String[] split = String.valueOf(n).split("");
        int num = 0;
        for (String aSplit : split) {
            num += Math.pow(Integer.valueOf(aSplit), 2);
        }
        if (num == 1) {
            return true;
        }
        if (num < 1) {
            return false;
        }
        if (num == 2 || num == 4) {
            return false;
        }
        return isHappy(num);
    }

    /**
     * 203-移除链表元素
     *
     * @param head .
     * @param val  .
     * @return .
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val != val) {
            head.next = removeElements(head.next, val);
            return head;
        }
        return removeElements(head.next, val);
    }

    /**
     * 204-计数质数
     * 厄拉多塞筛法
     *
     * @param n .
     * @return .
     */
    public static int countPrimes(int n) {
        int[] primes = new int[n];
        for (int i = 0; i < n; i++) {
            primes[i] = 1;
        }

        for (int i = 2; i < n; i++) {
            if (primes[i] != 1) {
                continue;
            }
            for (int j = 2; i * j < n; j++) {
                primes[i * j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 168-Excel表列名称
     * <p>
     * B = A + 1, AA  = A + 26,BA = AA + 26, AAA = AA
     *
     * @param n .
     * @return .
     */
    public String convertToTitle(int n) {
        return null;
    }

    /**
     * 172-阶乘后的零
     * <p>
     * 可以将问题转换成求乘法因子中5的个数 5 * 2 = 10
     *
     * @param n .
     * @return .
     */
    public int trailingZeroes(int n) {

        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    /**
     * 189-旋转数组
     *
     * @param nums .
     * @param k    .
     */
    public static void rotate(int[] nums, int k) {
        if (nums.length < 1) {
            return;
        }
        while (k > 0) {
            int temp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    nums[0] = nums[i];
                    nums[i] = temp;
                    continue;
                }
                int t = nums[i];
                nums[i] = temp;
                temp = t;

            }
            k--;
        }
    }

    /**
     * 108-将有序数组转换为二叉搜索树
     *
     * @param nums .
     * @return .
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, start, mid);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, end);
        return node;
    }

    /**
     * 110-平衡二叉树
     *
     * @param root .
     * @return .
     */
    public boolean isBalanced(TreeNode root) {
        List<String> flag = new ArrayList<>();
        isBalancedHelper(root, flag);
        return flag.size() == 0;
    }

    private int isBalancedHelper(TreeNode root, List<String> flag) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedHelper(root.left, flag);
        int right = isBalancedHelper(root.right, flag);
        if (Math.abs(left - right) > 1 && flag.size() == 0) {
            flag.add("a");
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 111-二叉树的最小深度
     *
     * @param root .
     * @return .
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }

    /**
     * 112-路径总和
     *
     * @param root .
     * @param sum  .
     * @return .
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (isLeaf(root)) {
            return (sum - root.val) == 0;
        }
        int val = sum - root.val;
        return hasPathSum(root.left, val) || hasPathSum(root.right, val);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    /**
     * 118-杨辉三角
     *
     * @param numRows .
     * @return .
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        generateHelper(list, numRows, 0);
        return list;
    }

    public void generateHelper(List<List<Integer>> list, int numRows, int index) {
        if (index == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            list.add(l);
        }
        if (index >= 1) {
            List<Integer> l = new ArrayList<>();
            List<Integer> top = list.get(index - 1);
            for (int i = 0; i <= index; i++) {
                int leftIndex = i - 1;
//                int rightIndex = i;
                if (leftIndex < 0) {
                    l.add(top.get(i));
                    continue;
                }
                if (i > top.size() - 1) {
                    l.add(top.get(leftIndex));
                    continue;
                }
                l.add(top.get(i) + top.get(leftIndex));
            }
            list.add(l);
        }
        index++;
        if (index == numRows) {
            return;
        }
        generateHelper(list, numRows, index);
    }

    /**
     * 119-杨辉三角 II
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        return getRowHelper(null, rowIndex + 1, 0);
    }

    public List<Integer> getRowHelper(List<Integer> list, int rowIndex, int index) {
        List<Integer> row = new ArrayList<>();
        if (index == 0 && list == null) {
            row.add(1);
        }
        if (index >= 1) {
            for (int i = 0; i <= index; i++) {
                int leftIndex = i - 1;
                if (leftIndex < 0) {
                    row.add(list.get(i));
                    continue;
                }
                if (i > list.size() - 1) {
                    row.add(list.get(leftIndex));
                    continue;
                }
                row.add(list.get(i) + list.get(leftIndex));
            }
        }
        index++;
        if (rowIndex == index) {
            return row;
        }
        return getRowHelper(row, rowIndex, index);
    }

    /**
     * 121-买卖股票的最佳时机
     *
     * @param prices .
     * @return .
     */
    public int maxProfit(int[] prices) {
        int maxSale = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int sale = prices[j] - prices[i];
                if (sale < 0) {
                    continue;
                }
                if (sale > maxSale) {
                    maxSale = sale;
                }
            }
        }
        return maxSale;
    }


    /**
     * 22-括号生成
     *
     * @param n .
     * @return .
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] chars = new char[n * 2];
        generateParenthesisHelper(list, chars, 0, n, n);
        return list;
    }

    private void generateParenthesisHelper(List<String> list, char[] chars, int index, int open, int close) {
        if (open == 0 && close == 0) {
            list.add(String.valueOf(chars));
            return;
        }
        if (open - 1 >= 0) {
            chars[index] = '(';
            generateParenthesisHelper(list, chars, index + 1, open - 1, close);
        }
        if (close - 1 >= open) {
            chars[index] = ')';
            generateParenthesisHelper(list, chars, index + 1, open, close - 1);
        }
    }

    /**
     * 141-环形链表
     *
     * @param head .
     * @return .
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 160-相交链表
     *
     * @param headA .
     * @param headB .
     * @return .
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 258-各位相加
     *
     * @param num .
     * @return .
     */
    public int addDigits(int num) {
        while (num >= 10) {
            String[] split = String.valueOf(num).split("");
            num = 0;
            for (String aSplit : split) {
                num += Integer.valueOf(aSplit);
            }
        }
        return num;
    }

    /**
     * 217-存在重复元素
     *
     * @param nums .
     * @return .
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 219. 存在重复元素 II
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                continue;
            }
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i] == nums[i1]) {
                    if (Math.abs(i - i1) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 226-翻转二叉树
     *
     * @param root .
     * @return .
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * 231-2的幂  -》 x的2次方n的二进制形式最高位是1,其他位为0。 n-1最高位是0,其他位为1 然后进行与运算(&)
     * @param n .
     * @return .
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 &&  0 == ((n-1) & n);
    }

    /**
     * 206-反转链表
     * @param head  .
     * @return .
     */
    public ListNode reverseList(ListNode head) {
        ListNode scp = null;
        while (head != null) {
            ListNode listNode = new ListNode(head.val);
            listNode.next = scp;
            scp = listNode;
            head = head.next;
        }
        return scp;
    }
}
