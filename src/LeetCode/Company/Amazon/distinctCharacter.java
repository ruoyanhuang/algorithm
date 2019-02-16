package LeetCode.Company.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class distinctCharacter {
    public List<String> allSubstring(String input, int k) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() < k) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), 1);
            } else {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }
            if (i >= k - 1) {
                if (i >= k) {
                    sb.deleteCharAt(0);
                    if (map.get(input.charAt(i - k)) == 1) {
                        map.remove(input.charAt(i - k));
                    } else {
                        map.put(input.charAt(i), map.get(input.charAt(i)) - 1);
                    }
                }
                if (map.size() == k) {
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}
