package LinkedList;

import entity.ListNode;

public class merge {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                curr.next = one;
                one = one.next;
                curr = curr.next;
            } else {
                curr.next = two;
                two = two.next;
                curr = curr.next;
            }
        }
        if (one == null) {
            curr.next = two;
        }
        if (two == null) {
            curr.next = one;
        }
        return dummyHead.next;
    }
}
