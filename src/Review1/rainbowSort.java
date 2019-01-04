package Review1;

public class rainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int left = 0;
        int panel = 0;
        int right = array.length - 1;
        while (panel <= right) {
            if (array[panel] == -1) {
                swap(array, panel++, left++);       //panel++: array[left] must be 0
            } else if (array[panel] == 0) {
                panel++;
            } else {
                swap(array, panel, right--);
            }
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
