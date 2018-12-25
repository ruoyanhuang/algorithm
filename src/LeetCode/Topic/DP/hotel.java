package LeetCode.Topic.DP;

import java.util.ArrayList;
import java.util.List;

public class hotel {
    public List<Integer> hotel(int[] miles) {
        if (miles == null || miles.length == 0) {
            return new ArrayList<>();
        }
        int[] dp = new int[miles.length];
        int[] laststop = new int[miles.length];
        dp[0] = (200 - miles[0]) * (200 - miles[0]);
        laststop[0] = -1;
        for (int i = 1; i < miles.length; i++) {
            int globalmin = Integer.MAX_VALUE;
            int position = -1;
            for (int j = 0; j < i; j++) {
                int tmp = miles[j] < 200 ? (200 - miles[j]) * (200 - miles[j]) : dp[j] + (200 - (miles[i] - miles[j])) * (200 - (miles[i] - miles[j]));
                if (tmp < globalmin) {
                    globalmin = tmp;
                    position = j;
                }
            }
            dp[i] = globalmin;
            laststop[i] = position;
        }
        List<Integer> res = new ArrayList<>();
        int start = miles.length - 1;
        while (start != -1) {
            res.add(laststop[start]);
            start = laststop[start];
        }
        return res;
    }
}
