package Recursion;

import entity.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class binaryTreePathSumToTargetIII {
    public boolean exist(TreeNode root, int target) {
        Set<Integer> set = new HashSet<>();
        return recursion(root, target, 0, set);
    }

    private boolean recursion(TreeNode root, int target, int prefix, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        prefix += root.val;
        set.add(prefix);
        if (set.contains(prefix - target)) {
            return true;
        }
        boolean left = recursion(root.left, target, prefix, set);
        boolean right = recursion(root.right, target, prefix, set);
        set.remove(prefix);
        return left || right;
    }
}
