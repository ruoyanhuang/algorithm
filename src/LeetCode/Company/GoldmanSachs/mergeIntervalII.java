package LeetCode.Company.GoldmanSachs;

import entity.ListNode;

public class mergeIntervalII {
    public ListNode mergeInterval2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = mergeInterval2(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
