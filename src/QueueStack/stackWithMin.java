package QueueStack;

import java.util.Deque;
import java.util.LinkedList;

public class stackWithMin {
    private Deque<Integer> one;
    private Deque<Integer> two;

    public stackWithMin() {
        this.one = new LinkedList<>();
        this.two = new LinkedList<>();
    }

    public int pop() {
        if (one == null || one.size() == 0) {
            return -1;
        }
        int result = one.removeFirst();
        two.pop();
        return result;
    }

    public void push(int element) {
        if (one == null || one.size() == 0) {
            one.addFirst(element);
            two.push(element);
        }
        int globalmin = two.peek();
        one.push(element);
        if (element >= globalmin) {
            two.push(globalmin);
        } else {
            two.push(element);
        }
    }

    public int top() {
        if (one == null || one.size() == 0) {
            return -1;
        } else {
            return one.getLast();
        }
    }

    public int min() {
        if (two == null || two.size() == 0) {
            return -1;
        } else {
            return two.peek();
        }
    }
}
