package String;

import java.util.HashSet;

public class remove {
    public String remove(String input, String t) {
        if (input == null) {
            return null;
        }
        if (t == null) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        HashSet<Character> target = new HashSet<Character>();
        for (int i = 0; i < t.length(); i++) {
            target.add(t.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            if (!target.contains(input.charAt(i))) {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }
}
