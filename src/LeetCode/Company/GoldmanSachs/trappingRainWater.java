package LeetCode.Company.GoldmanSachs;

public class trappingRainWater {
    public int trap(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int leftMax = 0;
//        int rightMax = 0;
//        int sum = 0;
//        while (left <= right) {
//            if (height[left] < height[right]) {
//                leftMax = Math.max(leftMax, height[left]);
//                sum += leftMax - height[left];
//                left++;
//            } else {
//                rightMax = Math.max(rightMax, height[right]);
//                sum += rightMax - height[right];
//                right--;
//            }
//        }
//        return sum;
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int j = rightMax.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int sum = 0;
        for (int k = 0; k < height.length; k++) {
            sum += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        return sum;
    }
}
