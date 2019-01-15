package LeetCode.Company.GoldmanSachs;

public class minimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int slow = 0;
        int fast = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (fast < nums.length) {
            while (fast < nums.length && sum < s) {
                sum += nums[fast++];
            }
            while (slow <= fast && sum >= s) {
                minLen = Math.min(minLen, fast - slow);
                sum -= nums[slow++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}