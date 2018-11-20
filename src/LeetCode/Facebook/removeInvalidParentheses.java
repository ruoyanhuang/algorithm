package LeetCode.Facebook;

import java.util.*;

public class removeInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        if (isValid(s)) {
            res.add(s);
            return res;
        }
        Set<String> isVisited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                for (int i = 0; i < cur.length(); i++) {
                    String tmp = cur.substring(0, i) + cur.substring(i + 1);
                    if (isValid(tmp) && !isVisited.contains(tmp)) {
                        res.add(tmp);
                        isVisited.add(tmp);
                    }
                    if (tmp.length() >= 2) {
                        queue.add(tmp);
                    }
                }
            }
            if (res.size() > 0) {
                return res;
            }
        }
        res.add("");
        return res;
    }

    public boolean isValid(String s) {
        if (s== null || s.length() == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ("(").toCharArray()[0]) {
                count++;
            } else if (s.charAt(i) == (")").toCharArray()[0]) {
                if (count <= 0) {
                    return false;
                } else {
                    count--;
                }
            }
        }
        return count == 0 ? true : false;
    }
}
