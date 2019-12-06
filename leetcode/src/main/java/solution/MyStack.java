package solution;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 225-用队列实现栈
 */
class MyStack {

    private Queue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public Integer pop() {
        if (queue.isEmpty()) {
            return null;
        }
        int size = queue.size();
        Object o = queue.toArray()[size - 1];
        queue.remove(o);
        return (int) o;
    }

    /**
     * Get the top element.
     */
    public Integer top() {
        if (queue.isEmpty()) {
            return null;
        }
        int size = queue.size();
        return (int) queue.toArray()[size - 1];
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
