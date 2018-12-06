//package LeetCode;
//
//import java.util.Map;
//
//public class subsequence {
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return 1;
//        }
//        int[] result = new int[nums.length];
//        result[0] = 1;
//        int globalmax = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int curmax = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    curmax = Math.max(curmax, result[j]);
//                }
//            }
//            result[i] = curmax + 1;
//            globalmax = Math.max(globalmax, result[i]);
//        }
//        return globalmax;
//        //return recursion(nums, nums.length - 1);
//    }
//
//    public int recursion(int[] nums, int index) {
//        if (index == 0) {
//            return 1;
//        }
//        int globalmax = 0;
//        for (int i = 0; i < index; i++) {
//            int localmax = recursion(nums, i);
//            if (nums[index] > nums[i]) {
//                globalmax = Math.max(localmax + 1, globalmax);
//            } else {
//                globalmax = Math.max(localmax, globalmax);
//            }
//        }
//        return globalmax;
//    }
//}
