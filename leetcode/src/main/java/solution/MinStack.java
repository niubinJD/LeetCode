package solution;

import assist.ListNode;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {
    private Integer min;

    private int capacity = 10;

    private int[] ele;

    private int size = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        ensureCapacity(capacity);
    }

    public void push(int x) {
        if (size >= ele.length) {
            ensureCapacity(capacity * 2 + 1);
        }
        ele[size++] = x;
        min = min == null ? x : (min < x ? min : x);
    }

    public void pop() {
        if (size > 0) {
            size--;
            adjustMinEle();
        }
    }

    public Integer top() {
        if (size <= 0) {
            return null;
        }
        return ele[size - 1];
    }

    public Integer getMin() {
        return min;
    }

    private void adjustMinEle() {
        min = null;
        for (int i = 0; i < size; i++) {
            if (min == null) {
                min = ele[i];
                continue;
            }
            if (min <= ele[i]) {
                continue;
            }
            min = ele[i];
        }
    }

    private void ensureCapacity(int size) {
        capacity = size;
        if (ele == null) {
            ele = new int[size];
            return;
        }
        ele = Arrays.copyOf(ele, size);
    }
}
