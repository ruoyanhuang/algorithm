package LeetCode.FaceBook;

public class subarraySumK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        prefix[1] = nums[0];
        for (int i = 2; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 1; i < prefix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prefix[i] - prefix[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
