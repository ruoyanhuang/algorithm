//package DP;
//
//public class longestSubArray {
//    public int longest(int[] array) {
//        if (array.length <= 1) {
//            return array.length;
//        }
//        int[] dp = new int[array.length];
//        dp[0] = 1;
//        int globalmax = 0;
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] > array[i - 1]) {
//                dp[i] = dp[i - 1] + 1;
//            } else {
//                dp[i] = 1;
//            }
//            globalmax = Math.max(globalmax, dp[i])
//        }
//        return globalmax;
//    }
//}
