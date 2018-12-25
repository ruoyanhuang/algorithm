package LeetCode.Company.Amazon;

import java.util.HashMap;
import java.util.Map;

public class firstUnique {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                array[i] = 1;
            } else {
                array[map.get(s.charAt(i))] += 1;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] == 1) {
                return j;
            }
        }
        return -1;
    }
}
