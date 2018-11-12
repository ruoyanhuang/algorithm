package LinkedList;

import entity.ListNode;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }
        boolean shift = false;
        ListNode prevl1 = null;
        ListNode prevl2 = null;
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        while (l1 != null && l2 != null) {
            if (shift == true) {
                if (l1.value + l2.value + 1 >= 10) {
                    l1.value = (l1.value + l2.value + 1) % 10;
                    shift = true;
                } else {
                    l1.value = l1.value + l2.value + 1;
                    shift = false;
                }
            } else {
                if (l1.value + l2.value >= 10) {
                    l1.value = (l1.value + l2.value) % 10;
                    shift = true;
                } else {
                    l1.value = l1.value + l2.value;
                    shift = false;
                }
            }
            prevl1 = l1;
            prevl2 = l2;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            l1= prevl1;
            l1.next = l2;
            l1 = l1.next;
            while (l1 != null) {
                if (shift == true) {
                    if (l1.value + 1 >= 10) {
                        l1.value = (l1.value + 1) % 10;
                        shift = true;
                    } else {
                        l1.value = l1.value + 1;
                        shift = false;
                    }
                }
                prevl1 = l1;
                l1 = l1.next;
            }
        } else if (l1 != null) {
            while (l1 != null) {
                if (shift == true) {
                    if (l1.value + 1 >= 10) {
                        l1.value = (l1.value + 1) % 10;
                        shift = true;
                    } else {
                        l1.value = l1.value + 1;
                        shift = false;
                    }
                }
                prevl1 = l1;
                l1 = l1.next;
            }
        }
        if (shift == true) {
            prevl1.next = new ListNode(1);
        }
        return dummy.next;
    }
}
