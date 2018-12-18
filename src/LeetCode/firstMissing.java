package LeetCode;

public class firstMissing {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int k = partition(nums);
        if (k == 0) {
            return nums[0] == 1 ? 2 : 1;
        }
        for (int i = 0; i <= k; i++) {
            int abs = Math.abs(nums[i]) - 1;
            if (abs <= k) {
                nums[abs] = nums[abs] < 0 ? nums[abs] : -nums[abs];
            }
        }
        for (int i = 0; i <= k; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return k + 2;
    }

    public int partition(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= 0) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        return  left > 0 ? --left : 0;
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
