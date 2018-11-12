package LinkedList;

import entity.ListNode;

public class mergeSort {
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return merge(head);
    }

    public ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middle(head);
        ListNode nextmid = mid.next;
        mid.next = null;
        ListNode one = merge(head);
        ListNode two = merge(nextmid);
        return combine(one, two);
    }

    public ListNode combine(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (one != null && two != null) {
            if (one.value < two.value) {
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
        } else {
            curr.next = one;
        }
        return dummyHead.next;
    }
}
