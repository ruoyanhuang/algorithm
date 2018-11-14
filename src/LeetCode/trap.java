package LeetCode;

public class trap {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int res = 0;
        int leftBound = height[0];
        for (int i = 1; i < height.length - 1; i++) {                   //Time complexity O(n^2)
            int rightBound = findRightBound(height, i);
            if (height[i] < Math.min(leftBound, rightBound)) {
                res += Math.min(leftBound, rightBound) - height[i];
            } else if (height[i] > leftBound) {
                leftBound = height[i];
            }
        }
        return res;
    }

    public int findRightBound(int[] height, int i) {
        int h= 0;
        for (int j = i + 1; j < height.length; j++) {
            h = Math.max(h, height[j]);
        }
        return h;
    }
}
