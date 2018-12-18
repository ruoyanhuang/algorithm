package LeetCode.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class reversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isNotation(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int y = stack.pop();
                int x = stack.pop();
                int z = calculate(x, y, tokens[i]);
                stack.push(z);
            }
        }
        return stack.pop();
    }

    public boolean isNotation(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int calculate(int x, int y, String s) {
        if (s.equals("+")) {
            return x + y;
        } else if (s.equals("-")) {
            return x - y;
        } else if (s.equals("*")) {
            return x * y;
        } else if (s.equals("/")) {
            return x / y;
        } else {
            return 0;
        }
    }
}
