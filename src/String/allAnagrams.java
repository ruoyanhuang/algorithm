package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allAnagrams {
    public List<Integer> allAnagrams(String sh, String lo) {
        if (lo.length() == 0 || sh.length() > lo.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int leftChar = 0;
        for (int i = 0; i < sh.length(); i++) {
            if (map.containsKey(sh.charAt(i))) {
                map.put(sh.charAt(i), map.get(sh.charAt(i)) + 1);
            } else {
                map.put(sh.charAt(i), 1);
                leftChar++;
            }
        }
        int start = 0;
        int end = sh.length() - 1;
        for (int i = start; i <= end; i++) {
            if (map.containsKey(lo.charAt(i))) {
                map.put(lo.charAt(i), map.get(lo.charAt(i)) - 1);
                if (map.get(lo.charAt(i)) == 0) {
                    leftChar--;
                }
            }
        }
        if (leftChar == 0) {
            res.add(0);
        }
        while (end < lo.length() - 1) {
            end++;
            if (map.containsKey(lo.charAt(start))) {
                if (map.get(lo.charAt(start)) == 0) {
                    leftChar++;
                }
                map.put(lo.charAt(start), map.get(lo.charAt(start)) + 1);
            }
            if (map.containsKey(lo.charAt(end))) {
                map.put(lo.charAt(end), map.get(lo.charAt(end)) - 1);
                if (map.get(lo.charAt(end)) == 0) {
                    leftChar--;
                }
            }
            start++;
            if (leftChar == 0) {
                res.add(start);
            }
        }
        return res;
    }
}
