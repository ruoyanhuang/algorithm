package Review1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class allValidPermutationsOfParenthesesII {
    private static final char[] parentheses = new char[]{'(',')','<','>','{','}'};

    public List<String> validParentheses(int l, int m, int n) {
        int[] count = new int[]{l,l,m,m,n,n};
        int length = 2 * (l + m + n);
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(count, length, stack, sb, res);
        return res;
    }

    private void dfs(int[] count, int length, Deque<Character> stack, StringBuilder sb, List<String> res) {
        if (sb.length() == length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < count.length; i++) {        //use for loop to decide which parentheses to operate on
            if (i % 2 == 0 && count[i] > 0) {
                sb.append(parentheses[i]);
                stack.push(parentheses[i]);
                count[i]--;
                dfs(count, length, stack, sb, res);
                count[i]++;
                stack.pop();
                sb.deleteCharAt(sb.length() - 1);
            } else if (i % 2 == 1 && stack.peek() == parentheses[i - 1]) {
                sb.append(parentheses[i]);
                stack.pop();
                count[i]--;
                dfs(count, length, stack, sb, res);
                count[i]++;
                stack.push(parentheses[i - 1]);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
