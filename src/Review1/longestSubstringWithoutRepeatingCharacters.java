package Review1;

import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        if (input == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int max = 1;
        while (right < input.length()) {
            if (set.add(input.charAt(right))) {
                right++;
            } else {
                while (set.contains(input.charAt(right))) {
                    set.remove(input.charAt(left));
                    left++;
                }
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
