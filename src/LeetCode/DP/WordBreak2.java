package LeetCode.DP;

import java.util.*;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<Integer>> path = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = -1; j <= i; j++) {
                if ((j == -1 || path.containsKey(j)) && dict.contains(s.substring(j + 1, i + 1))) {
                    if (!path.containsKey(i)) {
                        path.put(i, new ArrayList<>());
                    }
                    path.get(i).add(j);
                }
            }
        }
        if (!path.containsKey(s.length() - 1)) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(s.length() - 1);
        dfs(path, s.length() - 1, res, cur);
        return printstr(res, s);
    }

    public void dfs(Map<Integer, List<Integer>> path, int index, List<List<Integer>> res, List<Integer> cur) {
        if (index == -1) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (Integer next : path.get(index)) {
            cur.add(next);
            dfs(path, next, res, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public List<String> printstr(List<List<Integer>> res, String s) {
        List<String> result = new ArrayList<>();
        for (List<Integer> list : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = list.size() - 1; i > 0; i--) {
                if (list.get(i) != -1) {
                    sb.append(" ");
                }
                sb.append(s.substring(list.get(i) + 1, list.get(i - 1) + 1));
            }
            result.add(sb.toString());
        }
        return result;
    }
}
