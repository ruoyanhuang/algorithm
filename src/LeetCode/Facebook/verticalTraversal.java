package LeetCode.FaceBook;

import entity.TreeNode;

import java.util.*;

public class verticalTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] min = new int[]{Integer.MAX_VALUE};
        bfs(root, 0, map, min);
        for (int i = min[0]; i < map.size(); i++) {
            res.add(map.get(i));
        }
        return res;
    }

    private void bfs(TreeNode root, int col, Map<Integer, List<Integer>> map, int[] min) {
        Queue<TreeNode> node = new ArrayDeque<>();
        Queue<Integer> index = new ArrayDeque<>();
        node.offer(root);
        index.offer(col);
        while (!node.isEmpty()) {
            int size = node.size();
            for (int i = 0; i < size; i++) {
                TreeNode curnode = node.poll();
                int curindex = index.poll();
                if (map.containsKey(curindex)) {
                    map.get(curindex).add(curnode.key);
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(curnode.key);
                    map.put(curindex, tmp);
                }
                min[0] = Math.min(min[0], curindex);
                if (curnode.left != null) {
                    node.offer(curnode.left);
                    index.offer(curindex - 1);
                }
                if (curnode.right != null) {
                    node.offer(curnode.right);
                    index.offer(curindex + 1);
                }
            }
        }
    }
}
