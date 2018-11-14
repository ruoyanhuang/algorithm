package LeetCode;

import entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class NodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode n1, ListNode n2) {
        if (n1.value > n2.value) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;
        PriorityQueue<ListNode> localmin = new PriorityQueue<>(k, new NodeComparator());
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                localmin.add(lists[i]);
            }
        }
        while (localmin.size() > 0) {               //Time complexity O(n): num of nodes
            curr.next = localmin.remove();          //Space complexity O(k): size of lists
            if (curr.next.next != null) {
                localmin.add(curr.next.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
