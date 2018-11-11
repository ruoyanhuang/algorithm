package BinarySearch;

public class BSClosest {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                right = mid;
            } else if (target > array[mid]) {
                left = mid + 1;//TODO sdfsdfsdf
            } else {
                right = mid - 1;
            }
        }
        if (target == array[left]) {
            return left;
        } else {
            return right;
        }
    }
}
