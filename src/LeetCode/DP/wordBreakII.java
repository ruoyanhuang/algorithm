package LeetCode.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        Set<String> dict = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            dict.add(wordDict.get(i));
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        return dfs(s, 0, dict, res, sb);
    }

    public List<String> dfs(String s, int start, Set dict, List<String> res, StringBuilder sb) {
        for (int i = start + 1; i <= s.length(); i++) {
            String ss = s.substring(start, i);
            if (dict.contains(ss)) {
                if (start > 0) {
                    sb.append(" ");
                }
                sb.append(ss.toCharArray());
                if (i == s.length()) {
                    res.add(sb.toString());
                    return res;
                }
                dfs(s, i, dict, res, sb);
                sb.delete(start, sb.length());
//                if (sb.substring()) {
//                    sb.deleteCharAt(sb.length() - 1);
//                }
            }
        }
        return res;
    }

//    public List<String> wordBreak(String s, List<String> wordDict) {
//        if (s == null || s.length() == 0) {
//            return new ArrayList<>();
//        }
//
//        Set<String> dict = new HashSet<>();
//        for (int i = 0; i < wordDict.size(); i++) {
//            dict.add(wordDict.get(i));
//        }
//        List<String> res = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        return dfs(s, 0, dict, res, sb);
//    }
}
