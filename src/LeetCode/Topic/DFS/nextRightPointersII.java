package LeetCode.Topic.DFS;

public class nextRightPointersII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                TreeLinkNode cur = root;
                while (cur.next != null) {
                    cur = cur.next;
                    if (cur.left != null) {
                        root.left.next = cur.left;
                        break;
                    } else if (cur.right != null) {
                        root.left.next = cur.right;
                        break;
                    }
                }
            }
        }
        if (root.right != null) {
            TreeLinkNode curr = root;
            while (curr.next != null) {
                curr = curr.next;
                if (curr.left != null) {
                    root.right.next = curr.left;
                    break;
                } else if (curr.right != null) {
                    root.right.next = curr.right;
                    break;
                }
            }
        }
        if (root.right != null){                //must do right part recursion first
            connect(root.right);
        }
        if (root.left != null) {
            connect(root.left);
        }
    }
}
