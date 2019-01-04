package Review1;

import java.util.HashSet;
import java.util.Set;

public class removeCertainCharacters {
    public String remove(String input, String t) {
        if (input.length() == 0) {
            return input;
        }
        Set<Character> remove = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            remove.add(t.charAt(i));
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (!remove.contains(array[fast])) {
                array[slow] = array[fast];
                slow++;
            }
            fast++;
        }
        return new String(array, 0 ,slow);
    }
}
