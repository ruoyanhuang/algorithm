package Review1;

import java.util.ArrayList;
import java.util.List;

public class allValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, res, sb);
        return res;
    }

    private void dfs(int n, int left, int right, List<String> res, StringBuilder sb) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(n, left + 1, right, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            dfs(n, left, right + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
