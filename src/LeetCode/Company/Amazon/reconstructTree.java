package LeetCode.Company.Amazon;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class reconstructTree {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preOrder.length; i++) {
            map.put(preOrder[i], i);
        }
        return recursion(inOrder, preOrder, 0, 0, inOrder.length, map);
    }

    private TreeNode recursion(int[] inOrder, int[] preOrder, int preLeft, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        root.left = recursion(inOrder, preOrder, preLeft + 1, inLeft, map.get(preLeft) - 1, map);
        root.right = recursion(inOrder, preOrder, map.get(preLeft) + 1, map.get(preLeft) + 1, inRight, map);
        return root;
    }
}
