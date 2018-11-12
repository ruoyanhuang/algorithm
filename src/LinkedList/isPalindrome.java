package LinkedList;

import entity.ListNode;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = middle(head);
        mid = mid.next;
        ListNode tail = reverse(mid);
        boolean palindrom = true;
        while (head != null && tail != null) {
            if (head.value != tail.value) {
                palindrom = false;
                break;
            }
            head = head.next;
            tail = tail.next;
        }
        return palindrom;
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

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
