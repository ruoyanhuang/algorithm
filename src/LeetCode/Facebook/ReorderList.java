package LeetCode.FaceBook;

import entity.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode start = head;
        ListNode mid = findMiddle(start);
        ListNode midnext = mid.next;
        mid.next = null;
        midnext = reverse(midnext);
        merge(start, midnext);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (head1 != null && head2 != null) {
            tmp.next = head1;
            head1 = head1.next;
            tmp.next.next = head2;
            head2 = head2.next;
            tmp = tmp.next.next;
        }
        if (head1 != null) {
            tmp.next = head1;
        }
        if (head2 != null) {
            tmp.next = head2;
        }
    }
}
