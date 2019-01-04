package Review1;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class getKeysInBSTInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        getKey(root, min, max, res);
        return res;
    }

    private void getKey(TreeNode root, int min, int max, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.val > max) {
            getKey(root.left, min, max, res);
        } else if (root.val < min) {
            getKey(root.right, min, max, res);
        } else {
            getKey(root.left, min, max, res);
            res.add(root.val);
            getKey(root.right, min, max, res);
        }
    }
}
