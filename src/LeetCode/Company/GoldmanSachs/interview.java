package LeetCode.Company.GoldmanSachs;

import entity.ListNode;

public class interview {
    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//        ListNode cur = head;
//        ListNode prev = null;
//        while (head != null) {
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
        ListNode next = head.next;
        ListNode newHead = reverseLinkedList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
