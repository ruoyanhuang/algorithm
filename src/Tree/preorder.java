package Tree;
import java.util.List;

import java.util.ArrayList;

public class preorder {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
          this.key = key;
        }
    }
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        result.add(root.key);
        preOrder(root.left);
        preOrder(root.right);
        return result;
    }
}
