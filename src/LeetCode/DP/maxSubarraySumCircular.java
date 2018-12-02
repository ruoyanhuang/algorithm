package LeetCode.DP;

import java.util.Map;

public class maxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int premax = 0;
        int curmax = 0;
        int globalmax = Integer.MIN_VALUE;
        int premin = 0;
        int curmin = 0;
        int globalmin = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (premax > 0) {
                curmax = premax + A[i];
            } else {
                curmax = A[i];
            }
            premax = curmax;
            globalmax = Math.max(globalmax, curmax);
            if (i > 0 && i < A.length - 1) {
                if (premin < 0) {
                    curmin = curmin + A[i];
                } else {
                    curmin = A[i];
                }
                premin = curmin;
                globalmin = Math.min(globalmin, curmin);
            }
            sum += A[i];
        }
        return Math.max(globalmax, sum - globalmin);
    }
}
