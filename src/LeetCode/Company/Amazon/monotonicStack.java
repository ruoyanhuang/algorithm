package LeetCode.Company.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class monotonicStack {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[]{};
        }
        Deque<Integer> mstack = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!mstack.isEmpty() && mstack.peekFirst() < i - k + 1) {
                mstack.pollFirst();
            }
            while (!mstack.isEmpty() && mstack.peekLast() < nums[i]) {
                mstack.pollLast();
            }
            mstack.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[mstack.peekFirst()];
            }
        }
        return res;
    }
}
