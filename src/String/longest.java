package String;

import java.util.HashSet;
import java.util.Set;

public class longest {
    public int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int globalmax = 0;
        while (end < input.length()) {
            if (!set.contains(input.charAt(end))) {
                set.add(input.charAt(end));
                end++;
            } else {
                while (set.contains(input.charAt(end))) {
                    set.remove(input.charAt(start));
                    start++;
                }
            }
            globalmax = Math.max(globalmax, end - start);
        }
        return globalmax;
    }
}
