package Recursion;

import entity.TreeNodeP;

public class lowestCommonAncestorII {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        int leftHeight = height(one);
        int rightHeight = height(two);
        TreeNodeP upperNode = leftHeight <= rightHeight ? one : two;
        TreeNodeP lowerNode = leftHeight > rightHeight ? one : two;
        int diff = Math.abs(leftHeight - rightHeight);
        while (lowerNode != null && diff > 0) {
            lowerNode = lowerNode.parent;
            diff--;
        }
        while (upperNode != null && lowerNode != null && upperNode != lowerNode) {
            upperNode = upperNode.parent;
            lowerNode = lowerNode.parent;
        }
        if (upperNode == null || lowerNode == null) {
            return null;
        } else {
            return upperNode;
        }
    }

    private int height(TreeNodeP node) {
        int height = 0;
        while (node != null) {
            node = node.parent;
            height++;
        }
        return height;
    }
}
