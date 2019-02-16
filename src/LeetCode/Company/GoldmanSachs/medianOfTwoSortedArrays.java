package LeetCode.Company.GoldmanSachs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class medianOfTwoSortedArrays {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int sum = nums1.length + nums2.length;
//        double ans = 0;
//        if (sum % 2 == 1) {
//            int k = (sum + 1) / 2;
//            ans = binarySearch(nums1, nums2, 0, 0, k);
//        } else {
//            int k = sum / 2;
//            double ans1 = binarySearch(nums1, nums2, 0, 0, k);
//            double ans2 = binarySearch(nums1, nums2, 0, 0, k + 1);
//            ans = (ans1 + ans2) / 2;
//        }
//        return ans;
//    }
//
//    private double binarySearch(int[] nums1, int[] nums2, int bound1, int bound2, int k) {
//        if (bound1 >= nums1.length) {
//            return nums2[bound2 + k - 1];
//        }
//        if (bound2 >= nums2.length) {
//            return nums1[bound1 + k - 1];
//        }
//        if (k == 1) {
//            return Math.min(nums1[bound1], nums2[bound2]);
//        }
//        int mid1 = bound1 + k / 2 - 1;
//        int mid2 = bound2 + k / 2 - 1;
//        if (mid1 >= nums1.length) {
//            return binarySearch(nums1, nums2, bound1, mid2 + 1, (k + 1) / 2);
//        } else if (mid2 >= nums2.length) {
//            return binarySearch(nums1, nums2, mid1 + 1, bound2, (k + 1) / 2);
//        } else if (nums1[mid1] < nums2[mid2]) {
//            return binarySearch(nums1, nums2, mid1 + 1, bound2, (k + 1) / 2);
//        } else {
//            return binarySearch(nums1, nums2, bound1, mid2 + 1, (k + 1) / 2);
//        }
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] tmp1 = nums1;
            nums1 = nums2;
            nums2 = tmp1;
            int tmp2 = m;
            m = n;
            n = tmp2;
        }
        int min = 0;
        int max = m;
        while (min <= max) {
            int i = min + (max - min) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i > min && nums1[i - 1] > nums2 [j]) {
                max = i - 1;
            } else if (i < max && nums2[j - 1] > nums1[i]) {
                min = i + 1;
            } else {
                int leftMax = 0;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                int rightMin = 0;
                if (i == m) {
                    rightMin = nums2[j];
                } else if (j == n) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}
