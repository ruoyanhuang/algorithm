package LeetCode.Topic.DFS;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (root == null) {
            return res;
        }
        cur.add(root.val);
        dfs(root, sum, root.val, cur, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, int path, List<Integer> cur, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (path == sum) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        if (root.left != null) {
            cur.add(root.left.val);
            dfs(root.left, sum, path + root.left.val, cur, res);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            cur.add(root.right.val);
            dfs(root.right, sum, path + root.right.val, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
