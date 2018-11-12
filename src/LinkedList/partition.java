package LinkedList;

import entity.ListNode;

public class partition {
    public ListNode partition(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        ListNode dummysmall = new ListNode(0);
        ListNode small = dummysmall;
        ListNode dummybig = new ListNode(0);
        ListNode big = dummybig;
        while (head != null) {
            if (head.value < target) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = dummybig.next;
        big.next = null;
        return dummysmall.next;
    }

}
