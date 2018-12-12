package LeetCode.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> dq1;
    private Deque<Integer> dq2;

    public MinStack() {
        dq1 = new ArrayDeque<>();
        dq2 = new ArrayDeque<>();
    }

    public void push(int x) {
        dq1.offerFirst(x);
        if (dq1.isEmpty() || x < dq1.peek()) {
            dq2.offerFirst(x);
        } else {
            dq2.offerFirst(dq1.peek());
        }
    }

    public void pop() {
        dq1.pollFirst();
        dq2.pollFirst();
    }

    public int top() {
        return dq1.peek();
    }

    public int getMin() {
        return dq2.peek();
    }
}
