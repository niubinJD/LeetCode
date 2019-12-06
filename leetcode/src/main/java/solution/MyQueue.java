package solution;

import java.util.Stack;

/**
 * 232-用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> stack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        Object o = stack.toArray()[0];
        stack.remove(o);
        return (Integer) o;
    }

    /** Get the front element. */
    public Integer peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return (int) stack.toArray()[0];
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
