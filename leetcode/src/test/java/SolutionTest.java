import assist.ListNode;
import assist.TreeNode;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        String a = null;
        String b = null;
        System.out.println(a == b);
    }

    @Test
    void climbStairs() {
        int i = solution.climbStairs(44);
        System.out.println(i);
    }

    @Test
    void deleteDuplicates() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);

        solution.deleteDuplicates(node);
    }

    @Test
    void merge() {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        solution.merge(nums1, 3, nums2, 3);
    }

    @Test
    void isHappy() {
        boolean happy = solution.isHappy(19);
        assert happy;
        boolean happy1 = solution.isHappy(9);
        assert !happy1;
    }

    @Test
    void removeElements() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
//        listNode.next = null;
        ListNode listNode1 = solution.removeElements(listNode, 1);
        System.out.println();
    }

    @Test
    void countPrimes() {
        int i = solution.countPrimes(499979);
        System.out.println(i);
    }

    @Test
    void trailingZeroes() {
        int i = solution.trailingZeroes(5);
        assert i == 1;
    }

    @Test
    void isBalanced() {
//        [1,2,2,3,3,null,null,4,4]
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.left.left = new TreeNode(4);
        assert !solution.isBalanced(node);
    }

    @Test
    void minDepth() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.left.left = new TreeNode(4);
        int i = solution.minDepth(node);
        assert i == 3;
    }

    @Test
    void hasPathSum() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.left.left = new TreeNode(4);

        assert solution.hasPathSum(node, 6);
    }

    @Test
    void generate() {
        List<List<Integer>> generate = solution.generate(5);
        System.out.println();
    }

    @Test
    void getRow() {
        List<Integer> row = solution.getRow(3);
        System.out.println();
    }
}