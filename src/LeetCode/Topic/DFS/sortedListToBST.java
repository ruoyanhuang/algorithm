package LeetCode.Topic.DFS;

import entity.ListNode;
import entity.TreeNode;

public class sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = findMiddle(head);
        TreeNode root = new TreeNode(mid.value);
        if (mid == head) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}
