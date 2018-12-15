package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DictWord1 {
    public boolean canBreak(String input, String[] dict) {
        if (input == null || input.length() == 0 || dict == null || dict.length == 0 || dict[0] == null) {
            return false;
        }
        Set<String> set = new HashSet<>(Arrays.asList(dict));
        boolean[] dp = new boolean[input.length()];
        dp[0] = set.contains(input.charAt(0));
        for (int i = 1; i < dp.length; i++) {
            if (set.contains(input.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(input.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    continue;
                }
            }
        }
        return dp[input.length() - 1];
    }
}
