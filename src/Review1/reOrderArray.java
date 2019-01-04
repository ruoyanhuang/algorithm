package Review1;

public class reOrderArray {
    public int[] reorder(int[] array) {
        int end;
        if (array.length % 2 == 0) {
            end = array.length - 1;
        } else {
            end = array.length - 2;
        }
        merge(array, 0, end);
        return array;
    }

    private void merge(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }
        int mid = left + length / 2;
        int leftmid = left + length / 4;
        int rightmid = left + length * 3 / 4;
        reverse(array, leftmid, mid - 1);
        reverse(array, mid, rightmid - 1);
        reverse(array, leftmid, rightmid - 1);
        merge(array, left, left + (leftmid - left) * 2 - 1);            //cannot directly use mid here
        merge(array, left + (leftmid - left) * 2, right);
    }

    private void reverse(int[] array, int left ,int right) {
        while (left < right) {
            swap(array, left--, right++);
        }
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
