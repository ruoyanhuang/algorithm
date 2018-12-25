package LeetCode.Company.Amazon;

import java.util.HashSet;
import java.util.Set;

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }

public class randomCopy {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newHead = dummy;
        Set<RandomListNode> set = new HashSet<>();
        while (head != null) {
            newHead.next = new RandomListNode(head.label);
            if (set.contains(head.random) || head.random == null) {
                newHead.next.random = head.random;
            } else {
                newHead.next.random = new RandomListNode(head.random.label);
                set.add(newHead.next.random);
            }
            newHead = newHead.next;
            head = head.next;
        }
        return dummy.next;
    }
}
