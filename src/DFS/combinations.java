package DFS;

import java.util.ArrayList;
import java.util.List;

public class combinations {
    public List<List<Integer>> combinations(int target, int[] coins) {
        if (coins == null || coins.length == 0 || target == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(target, coins, 0, res, cur);
        return res;
    }

    public void dfs(int target, int[] coins, int level, List<List<Integer>> res, List<Integer> cur) {
        if (level == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[level];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            dfs(target - i * coins[level], coins, level + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
