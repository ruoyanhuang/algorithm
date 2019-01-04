package Review1;

public class mergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        return merge(array,left,right);
    }

    public int[] merge(int[] array, int left, int right) {
        if (left >= right) {
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftSide = merge(array, left, mid);
        int[] rightSide = merge(array, mid + 1, right);
        return combine(leftSide, rightSide);
    }

    public int[] combine(int[] leftSide, int[] rightSide) {
        int[] res = new int[leftSide.length + rightSide.length];
        int l = 0;
        int r = 0;
        int start = 0;
        while (l < leftSide.length && r <rightSide.length) {
            if (leftSide[l] < rightSide[r]) {
                res[start++] = leftSide[l++];
            } else {
                res[start++] = rightSide[r++];
            }
        }
        while (l < leftSide.length) {
            res[start++] = leftSide[l++];
        }
        while (r < rightSide.length) {
            res[start++] = rightSide[r++];
        }
        return res;
    }
}
