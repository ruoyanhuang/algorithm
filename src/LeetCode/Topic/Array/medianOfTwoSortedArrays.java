//package LeetCode.Topic.Array;
//
//public class medianOfTwoSortedArrays {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        int imin = 0;
//        int imax = m;
//        int i;
//        int j;
//        while (imin < imax) {
//            i = (imin + imax) / 2;
//            j = (m + n + 1) / 2 - i;
//            if (nums1[i - 1] < nums2[j] && nums2[j - 1] < nums1[i]) {
//                break;
//            } else if (nums1[i - 1] >= nums2[j]) {
//                imax = i - 1;
//            } else {
//                imin = i + 1;
//            }
//        }
//        if ()
//        if ((m + n) % 2 == 1) {
//            return Math.max(nums1[i - 1], nums2[j - 1]);
//        } else {
//            return (Math.max(nums1[i - 1], nums2[j - 1]) + Math.min(nums1[i], nums2[j])) / 2;
//        }
//    }
//
//}
