package Review1;

import entity.ListNode;

public class reverseLinkedList {
//    public ListNode reverse(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
