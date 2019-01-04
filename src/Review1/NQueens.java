package Review1;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, cur, res);
        return res;
    }

    private void dfs(int n, List<Integer> cur, List<List<Integer>> res) {
        int index = cur.size();
        if (index == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValidQueen(cur, index, i)) {
                cur.add(i);
                dfs(n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isValidQueen(List<Integer> cur, int row, int col) {
        for (int i = 0; i < cur.size(); i++) {
            if (col == cur.get(i) || row - i == Math.abs(col - cur.get(i))) {
                return false;
            }
        }
        return true;
    }
}
