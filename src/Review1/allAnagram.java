package Review1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allAnagram {
    public List<Integer> allAnagrams(String sh, String lo) {
        List<Integer> res = new ArrayList<>();
        if (lo.length() == 0) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sh.length(); i++) {
            if (!map.containsKey(sh.charAt(i))) {
                map.put(sh.charAt(i), 1);
            } else {
                map.put(sh.charAt(i), map.get(sh.charAt(i)) + 1);
            }
        }
        int count = map.size();
        int slow = 0;
        int fast = 0;
        while (fast <= lo.length()) {
            if (fast - slow == sh.length()) {
                if (count == 0) {
                    res.add(slow);
                }
                if (map.containsKey(lo.charAt(slow))) {
                    map.put(lo.charAt(slow), map.get(lo.charAt(slow)) + 1);
                    if (map.get(lo.charAt(slow)) == 1) {
                        count++;
                    }
                }
                slow++;
            } else {
                if (fast < lo.length() && map.containsKey(lo.charAt(fast))) {
                    map.put(lo.charAt(fast), map.get(lo.charAt(fast)) - 1);
                    if (map.get(lo.charAt(fast)) == 0) {
                        count--;
                    }
                }
                fast++;
            }
        }
        return res;
    }
}
