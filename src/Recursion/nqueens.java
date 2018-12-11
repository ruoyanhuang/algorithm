package Recursion;

import java.util.ArrayList;
import java.util.List;

public class nqueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> position = new ArrayList<>();
        allqueens(n, 0, position, res);
        return res;
    }

    public void allqueens(int n, int level, List<Integer> position, List<List<Integer>> res) {
        if (level == n) {
            res.add(new ArrayList<>(position));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(level, i, position)) {
                position.add(i);
                allqueens(n, level + 1, position, res);
                position.remove(position.size() - 1);
            }
        }
    }

    public boolean isValid(int row, int col, List<Integer> position) {
        for (int i = 0; i < row; i++) {
            if (position.get(i) == col) {
                return false;
            } else if (Math.abs(i - row) == Math.abs(position.get(i) - col)) {
                return false;
            }
        }
        return true;
    }
}
