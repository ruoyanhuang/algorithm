package LeetCode.Company.FaceBook;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int tmp = findSmallestLarger(nums, nums[i], i + 1);
                swap(nums, i, tmp);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
        return;
    }

    public int findSmallestLarger(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return target < nums[right] ? right : left;
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public void reverse(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
