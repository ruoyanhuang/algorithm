package LinkedList;

import entity.ListNode;

import java.util.LinkedList;

public class sort {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        if (s1 == null) {
            return;
        }
        int globalmin = Integer.MAX_VALUE;
        while (s1 != null) {
            int out = s1.removeFirst();
            if (out < globalmin) {
                globalmin = out;
            }
            s2.add(out);
        }
        while (s2 != null && s2.peek() > globalmin) {
            int back = s2.removeFirst();
            if (back != globalmin) {
                s1.add(back);
            }
        }
    }
}
