package LeetCode.Company.GoldmanSachs;

import java.util.*;

public class shortestSubarraySumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int res = Integer.MAX_VALUE;
        int[] prefix = new int[A.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int j = 0; j < prefix.length; j++) {
            if (!dq.isEmpty() && prefix[j] > prefix[dq.peekLast()]) {
                dq.pollLast();
            }
            if (!dq.isEmpty() && prefix[j] - prefix[dq.peekFirst()] >= K) {
                res = Math.min(res, j - dq.pollFirst());
            }
            dq.offerLast(j);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
