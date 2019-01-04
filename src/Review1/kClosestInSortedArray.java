package Review1;

public class kClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        int[] res = new int[k];
        int left = smallestLargest(array, target);
        int right = left + 1;
        for (int i = 0; i < res.length; i++) {
            if (right >= array.length || left >= 0 && target - array[left] <= array[right] - target) {
                res[i] = array[left];
                left--;
            } else {
                res[i] = array[right];
                right++;
            }
        }
        return res;
    }

    private int smallestLargest(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[right] < target) {
            return right;
        } else if (array[left] < target) {
            return left;
        } else {
            return -1;
        }
    }
}
