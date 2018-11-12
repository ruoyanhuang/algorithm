package LinkedList;

import entity.ListNode;

public class insert {
    public ListNode insert(ListNode head, int value) {
        if (head == null) {
            return new ListNode(value);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode target = new ListNode(value);
        dummyHead.next = head;
        while (head != null) {
            if (head.value > value) {
                target.next = head;
                dummyHead.next = target;
                return dummyHead.next;
            } else if (head.value <= value && head.next == null) {
                head.next = target;
                return dummyHead.next;
            } else if (head.value <= value && head.next.value >= value) {
                target.next = head.next;
                head.next = target;
                return dummyHead.next;
            } else {
                head = head.next;
            }
        }
        return null;
    }
}
