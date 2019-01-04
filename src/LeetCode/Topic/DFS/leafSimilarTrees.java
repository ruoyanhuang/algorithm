package LeetCode.Topic.DFS;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else {
            dfs(root1, list1);
            dfs(root2, list2);
            if (list1.size() != list2.size()) {
                return false;
            }
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, res);
        }
        if (root.right != null) {
            dfs(root.right, res);
        }
    }
}
