package LeetCode.Topic.Array;

public class findDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int sum1 = (1 + nums.length - 1) * nums.length / 2;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        int target = sum2 - sum1;
        int count = 2;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target) {
                count--;
            }
            if (count == 0) {
                return j;
            }
        }
        return -1;
    }
}
