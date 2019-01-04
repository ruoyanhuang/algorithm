package Review1;

import entity.ListNode;

public class partitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummySmall = new ListNode(0);
        ListNode dummyBig = new ListNode(0);
        ListNode small = dummySmall;
        ListNode big = dummyBig;
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
        small.next = dummyBig.next;
        big.next = null;
        return dummySmall.next;
    }
}
