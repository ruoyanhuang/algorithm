package LeetCode.Topic.String;

import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.add(s.charAt(right))) {
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
