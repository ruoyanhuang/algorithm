package LeetCode.Company.FaceBook;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        int res = quickSelect(nums, 0, nums.length - 1, k);
        return res;
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int index = partition(nums, left, right);
        if (index == k) {
            return nums[index];
        } else if (index > k) {
            quickSelect(nums, left, index, k);
        } else {
            quickSelect(nums, index, right, k);
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = (int) Math.random() * (start - end + 1);
        int target = nums[pivot];
        swap(nums, pivot, end);
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (nums[left] < target) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        swap(nums, left, end);
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
