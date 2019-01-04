package LeetCode.Company.Amazon;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        recursion(root, target, K, res);
        return res;
    }

    public int recursion(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null) {
            return 0;
        }
        if (root.equals(target)) {
            bfs(root, K, res);
            return 1;
        }
        int left = recursion(root.left, target, K, res);
        int right = recursion(root.right, target, K, res);
        if (left > 0) {
            if (left == K) {
                res.add(root.val);
                return 0;
            } else {
                bfs(root.right, K - left - 1, res);
                return left + 1;
            }
        }
        if (right > 0) {
            if (right == K) {
                res.add(root.val);
                return 0;
            } else {
                bfs(root.left, K - right - 1, res);
                return right + 1;
            }
        }
        return 0;
    }

    public void bfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            res.add(root.val);
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (level >= 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (level == 0) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level--;
        }
    }
}
