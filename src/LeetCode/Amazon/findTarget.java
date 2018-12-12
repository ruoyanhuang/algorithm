package LeetCode.Amazon;

import entity.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class findTarget {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(k - root.key);
        preorder(root, k, set);
        return
    }

    public boolean preorder(TreeNode root, int k, Set<Integer> set) {
        if ()
    }
}
