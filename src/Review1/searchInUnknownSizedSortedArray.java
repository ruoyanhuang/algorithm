package Review1;

interface Dictionary {
    public Integer get(int index);
}

public class searchInUnknownSizedSortedArray {
    public int search(Dictionary dict, int target) {
        int left = 0;
        int right = 1;
        while (dict.get(right) != null && target > dict.get(right)) {
            left = right;
            right *= 2;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || dict.get(mid) > target) {
                right = mid - 1;
            } else if (dict.get(mid) == target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
