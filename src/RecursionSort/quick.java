package RecursionSort;

public class quick {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        if (array.length == 1) {
            return array;
        }
        quicksort(array, 0, array.length - 1);
        return array;
    }

    public void quicksort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partation(a, left, right);
        quicksort(a, left, index - 1);
        quicksort(a, index + 1, right);
    }

    public void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    public int partation(int[] a, int l, int r) {
        int pivot = (int) (Math.random() * (r - l + 1)) + l;
        int target = a[pivot];
        swap(a, pivot, r);
        int i = l;
        int j = r - 1;
        while (i <= j) {
            if (a[i] < target) {
                i++;
            } else if (a[j] >= target) {
                j--;
            } else {
                swap(a, i, j);
            }
        }
        swap(a, i, r);
        return i;
    }

}
