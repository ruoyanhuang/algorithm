package Mock;

import entity.LabelTreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class labelTree {
    public List<String> findLargestSubTree(LabelTreeNode root) {
        List<String> res = new ArrayList<>();
        Set<LabelTreeNode> path = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return res;
        }
        dfs(root, path);
        lca(root, sb, path, res);
        return res;
    }

    private boolean dfs(LabelTreeNode root, Set<LabelTreeNode> path) {
        if (root.left == null && root.right == null) {
            if (root.label.equals("good")) {
                return true;
            } else {
                return false;
            }
        }
        boolean left = root.left == null ? true : dfs(root.left, path);
        boolean right = root.right == null ? true : dfs(root.right, path);
        if (left && right) {
            return true;
        } else if (left) {
            if (root.left != null && root.left.label.equals("")) {
                path.add(root.left);
            }
            return false;
        } else if (right) {
            if (root.right != null && root.right.label.equals("")) {
                path.add(root.right);
            }
            return false;
        } else {
            return false;
        }
    }

    private void lca(LabelTreeNode root, StringBuilder sb, Set<LabelTreeNode> path, List<String> res) {
        if (root == null) {
            return;
        }
        sb.append(root.key);
        if (path.contains(root)) {
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);       //caution!!!
            return;
        }
        lca(root.left, sb, path, res);
        lca(root.right, sb, path, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
