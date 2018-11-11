package RecursionSort;

public class movezero {
    public int[] moveZero(int[] array) {
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        if (array.length == 1) {
            return array;
        }
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (array[i] == 0) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                j--;
            } else {
                i++;
            }
        }
        return array;
    }
}
