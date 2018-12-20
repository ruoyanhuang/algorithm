package LeetCode.FaceBook;

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int globalmin = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), 1);
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
        }
        int count = map.size();
        int slow = 0;
        int fast = 0;
        int start = -1;
        int end = -1;
        while (fast < s.length()) {
            while (fast < s.length() && count > 0) {
                if (map.containsKey(s.charAt(fast))) {
                    map.put(s.charAt(fast), map.get(s.charAt(fast)) - 1);
                    if (map.get(s.charAt(fast)) == 0) {
                        count--;
                    }
                }
                fast++;
            }
            fast--;
            while (slow < fast && count == 0) {
                if (fast - slow + 1 < globalmin) {
                    start = slow;
                    end = fast;
                    globalmin = fast - slow + 1;
                }
                if (map.containsKey(s.charAt(slow))) {
                    map.put(s.charAt(slow), map.get(s.charAt(slow)) + 1);
                    if (map.get(s.charAt(slow)) == 1) {
                        count++;
                    }
                }
                slow++;
            }
        }
        if (start == -1 || end == -1) {
            return "";
        } else {
            return s.substring(start, end + 1);
        }
    }
}
