package Review1;

import java.util.ArrayList;
import java.util.List;

public class combinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(coins, target, 0, res, cur);
        return res;
    }

    private void dfs(int[] coins, int target, int level, List<List<Integer>> res, List<Integer> cur) {
        if (level == coins.length - 1) {
            if (target % coins[level] == 0) {
                cur.add(target / coins[level]);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);             //do not forget this backtrack
            }
            return;
        }
        int max = target / coins[level];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            dfs(coins, target - i * coins[level], level + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
