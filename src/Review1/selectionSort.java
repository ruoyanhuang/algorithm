package Review1;

public class selectionSort {
    public int[] solve(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minindex]) {
                    minindex = j;
                }
            }
            swap(array,i,minindex);
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
