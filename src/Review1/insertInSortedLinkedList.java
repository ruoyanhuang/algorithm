package Review1;

import entity.ListNode;

public class insertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        ListNode insert = new ListNode(value);
        if (head == null || head.value >= value) {
            insert.next = head;
            return insert;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            if (cur.value < value && next.value >= value) {
                cur.next = insert;
                insert.next = next;
                return head;
            }
            cur = next;
            next = next.next;
        }
        cur.next = insert;
        return head;
    }
}
