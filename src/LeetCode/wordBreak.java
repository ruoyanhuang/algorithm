package LeetCode;

import java.util.List;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return recursion(s, wordDict);
    }

    public boolean recursion(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        boolean res = false;
        for (int i = 0; i < wordDict.size(); i++) {
            boolean isMatch = true;
            for (int j = 0; j < wordDict.get(i).length(); j++) {
                if (s.length() < wordDict.get(i).length() || s.charAt(j) != wordDict.get(i).charAt(j)) {
                    isMatch = false;
                }
            }
            if (isMatch) {
                res = recursion(s.substring(wordDict.get(i).length()), wordDict);
            }
        }
        return res;
    }
}
