package LeetCode.FaceBook;

import java.util.HashSet;
import java.util.Set;

public class continuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        k = Math.abs(k);
        int prefix0 = nums[0];
        int prefix1 = nums[0] + nums[1];
        Set<Integer> set = new HashSet<>();
        if (k != 0) {
            if (prefix1 % k == 0) return true;
            set.add(prefix0 % k);
        }
        for (int i = 2; i < nums.length; i++) {
            prefix1 = prefix1 + nums[i];
            if (nums[i] == 0 && nums[i - 1] == 0) return true;
            if (k != 0) {
                if (set.contains(prefix1 % k)) return true;
                prefix0 = prefix0 + nums[i - 1];
                set.add(prefix0 % k);
            }
        }
        return false;
    }
}
