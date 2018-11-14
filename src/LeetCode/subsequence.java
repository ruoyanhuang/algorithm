package LeetCode;

public class subsequence {
    public int lengthOfLIS(int[] nums) {
//        int[] result = new int[nums.length];
//        result[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            result[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if ()
//            }
//        }

        return recursion(nums, nums.length - 1);
    }

    public int recursion(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }
        int globalmax = 0;
        for (int i = 0; i < index; i++) {
            int localmax = recursion(nums, i);
            if (nums[index] > nums[i]) {
                globalmax = Math.max(localmax + 1, globalmax);
            } else {
                globalmax = Math.max(localmax, globalmax);
            }
        }
        return globalmax;
    }
}
