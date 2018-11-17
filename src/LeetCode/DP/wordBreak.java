package LeetCode.DP;

import java.util.List;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isSubword = new boolean[s.length() + 1];
        isSubword[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length(); j > i; j--) {
                if (isSubword[j] && wordDict.contains(s.substring(i,j))) {
                    isSubword[i] = true;
                }
            }
        }
        return isSubword[0];
    }
}
