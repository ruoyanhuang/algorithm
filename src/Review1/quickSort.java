package Review1;

public class quickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        quick(array, left, right);
        return array;
    }

    private void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quick(array, left, index - 1);
        quick(array, index + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = (int) Math.random() * (right - left + 1) + left;
        int target = array[pivot];
        int leftBound = left;
        int rightBound = right - 1;
        swap(array, pivot, right);
        while (leftBound <= rightBound) {
            if (array[leftBound] < target) {
                leftBound++;
            } else if (array[rightBound] >= target) {
                rightBound--;
            } else {
                swap(array, leftBound, rightBound);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
