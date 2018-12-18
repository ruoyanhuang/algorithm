package LeetCode.Amazon;

public class ProductofArray {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        } else if (nums.length == 1) {
            return new int[]{0};
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j++) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        res[0] = right[1];
        res[nums.length - 1] = left[nums.length - 2];
        for (int k = 1; k < nums.length - 1; k++) {
            res[k] = left[k - 1] * right[k + 1];
        }
        return res;
    }
}
