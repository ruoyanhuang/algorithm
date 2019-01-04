package LeetCode.Topic.DFS;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        dfs(root, res, cur);
        return res;
    }

    private void dfs(TreeNode root, List<String> res, List<Integer> cur) {
        if (root.left == null && root.right == null) {
            construct(res, cur);                        //caution: cannot operate on sb during backtracking!! (int digit uncertain)
            return;
        }
        if (root.left != null) {
            cur.add(root.left.val);
            dfs(root.left, res, cur);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            cur.add(root.right.val);
            dfs(root.right, res, cur);
            cur.remove(cur.size() - 1);
        }
    }

    private void construct(List<String> res, List<Integer> cur) {
        if (cur == null || cur.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cur.get(0));
        for (int i = 1; i < cur.size(); i++) {
            sb.append("->");
            sb.append(cur.get(i));
        }
        res.add(sb.toString());
    }
}
