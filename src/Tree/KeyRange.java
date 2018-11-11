package Tree;

import java.util.List;
import java.util.ArrayList;

public class KeyRange {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> getRange(TreeNode root, int min, int max) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        if (root.key < min) {
            getRange(root.right, min, max);
        } else if (root.key > max) {
            getRange(root.left, min, max);
        } else {
            getRange(root.left, min, max);
            result.add(root.key);
            getRange(root.right, min, max);
        }
        return result;
    }
}
