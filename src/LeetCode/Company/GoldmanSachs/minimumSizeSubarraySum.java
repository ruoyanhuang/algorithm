package LeetCode.Company.GoldmanSachs;

public class minimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int curSum = 0;
        int minLen = nums.length + 1;
        while (right < nums.length) {
            if (curSum < s) {
                curSum += nums[right++];
                while (curSum >= s) {
                    minLen = Math.min(minLen, right - left);
                    curSum -= nums[left++];
                }
            }
        }
        return minLen == nums.length ? -1 : minLen;
    }
}