package DFS;

import java.util.ArrayList;
import java.util.List;

public class combine {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, k, 1, cur, res);
        return res;
    }

    public void dfs(int n, int k, int level, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (level > n || cur.size() > 2) {
            return;
        }
        cur.add(level);
        dfs(n, k, level + 1, cur, res);
        cur.remove(cur.size() - 1);
        dfs(n, k, level+ 1, cur, res);
    }
}
