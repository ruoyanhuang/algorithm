package BinarySearch;

public class insert {
    public int searchInsert(int[] input, int target) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int left = 0;
        int right = input.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left)/2;
            if (target <= input[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (input[left] > target) {
            return 0;
        } else if (input[left] < target && input[right] >= target) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
}
