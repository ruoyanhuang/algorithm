package DFS;

import java.util.ArrayList;
import java.util.List;

public class validParentheses {
    public List<String> validParentheses(int n) {
        if (n == 0) {
            return new ArrayList<String>();
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        return dfs(n, 0, 0, sb, res);
    }

    public List<String> dfs(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return res;
        }
        if (left < n) {
            sb.append("(");
            dfs(n, left +1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            dfs(n, left, right +1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        return res;
    }







    public List<String> validParentheses2(int n) {
        if (n == 0) {
            return new ArrayList<String>();
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs2(n, 0, 0, sb, res);
        return res;
    }
    public void dfs2(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            dfs2(n, left +1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            dfs2(n, left, right +1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}


