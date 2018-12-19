package LeetCode.Facebook;

import java.util.HashSet;
import java.util.Set;

public class continuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        if ((nums[0] + nums[1]) % k == 0) return true;
        Set<Integer> set = new HashSet<>();
        int prefix = nums[0] + nums[1];
        set.add(prefix % k);
        for (int i = 2; i < nums.length; i++) {
            prefix = prefix + nums[i];
            if (nums[i] % k != 0 && set.contains(prefix % k)) {
                return true;
            }
            set.add(prefix % k);
        }
        return false;
    }
}
