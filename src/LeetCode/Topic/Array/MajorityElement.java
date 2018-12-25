package LeetCode.Topic.Array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (i < nums.length - 1 && count == 0) {
                    candidate = nums[i + 1];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}
