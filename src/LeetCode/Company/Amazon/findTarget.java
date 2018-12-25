package LeetCode.Company.Amazon;

import entity.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class findTarget {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        return preorder(root, k, set);
    }

    public boolean preorder(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(root.key)) {
            return true;
        }
        set.add(k - root.key);
        return preorder(root.left, k, set) || preorder(root.right, k, set);
    }
}
