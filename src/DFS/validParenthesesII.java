package DFS;

import java.util.*;

public class validParenthesesII {
    private static char[] parentheses = new char[]{'(',')','[',']','{','}'};

    public List<String> validParentheses(int l, int m, int n) {
        int[] remaining = new int[]{l, l, m, m, n, n};
        int length = 2 * (l + m + n);
        List<String> res = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        dfs(remaining, length, res, stack, sb);
        return res;
    }

    private void dfs(int[] remaining, int length, List<String> res, Deque<Character> stack, StringBuilder sb) {
        System.out.println(sb.toString());
        System.out.println(Arrays.toString(remaining));
        System.out.println(stack.size());
        if (sb.length() == length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < remaining.length; i++) {
            if (i % 2 == 0) {
                if (remaining[i] > 0) {
                    sb.append(parentheses[i]);
                    remaining[i]--;
                    stack.offerFirst(parentheses[i]);
                    dfs(remaining, length, res, stack, sb);
                    stack.pollFirst();
                    remaining[i]++;
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == parentheses[i - 1]) {
                    sb.append(parentheses[i]);
                    remaining[i]--;
                    stack.pollFirst();
                    dfs(remaining, length, res, stack, sb);
                    stack.offerFirst(parentheses[i - 1]);
                    remaining[i]++;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
