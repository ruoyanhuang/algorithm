package LeetCode.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class validParentheses {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        char[] array = new char[]{'(', '[', '{', ')', ']', '}'};
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == array[0] || s.charAt(i) == array[1] || s.charAt(i) == array[2]) {
                dq.offerLast(s.charAt(i));
            } else if (dq.isEmpty()) {
                return false;
            } else if (s.charAt(i) == array[3]) {
                if (dq.peekLast() == array[0]) {
                    dq.pollLast();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == array[4]) {
                if (dq.peekLast() == array[1]) {
                    dq.pollLast();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == array[5]) {
                if (dq.peekLast() == array[2]) {
                    dq.pollLast();
                } else {
                    return false;
                }
            }
        }
        if (dq.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
