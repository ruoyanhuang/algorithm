package LeetCode.Company.GoldmanSachs;

import java.util.*;

public class shortestSubarraySumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int[] prefix = new int[A.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }
        int res = prefix.length;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int j = 0; j < prefix.length; j++) {
            while (!dq.isEmpty() && prefix[j] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }
            while (!dq.isEmpty() && prefix[j] - prefix[dq.peekFirst()] >= K) {
                res = Math.min(res, j - dq.pollFirst());
            }
            dq.offerLast(j);
        }
        return res == prefix.length ? -1 : res;
    }
}
