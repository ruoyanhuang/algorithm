package RecursionSort;

public class rainbow {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        if (array.length == 1) {
            return array;
        }
        int i = 0;
        int j=0;
        int k = array.length - 1;
        while (j <= k) {
            if (array[j] == -1) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                i++;
                j++;
            } else if (array[j] == 0) {
                j++;
            } else {
                int tmp = array[j];
                array[j] = array[k];
                array[k] = tmp;
                k--;
            }
        }
        return array;
    }
}
