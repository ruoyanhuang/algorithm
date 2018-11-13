package LeetCode;

import java.util.HashMap;

public class isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> str = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (str.containsKey(s.charAt(i))) {
                str.put(s.charAt(i), str.get(s.charAt(i)) + 1);
            } else {
                str.put(s.charAt(i), 1);
            }
        }
        for (int j = 0; j < t.length(); j++) {
            if (!str.containsKey(t.charAt(j)) || str.get(t.charAt(j)) == 0) {
                return false;
            } else {
                str.put(t.charAt(j), str.get(t.charAt(j)) - 1);
            }
        }
        return true;
    }
}
