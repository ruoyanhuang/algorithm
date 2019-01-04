package Review1;

public class move0ToEnd {
    public int[] moveZero(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] != 0) {
                left++;
            } else if (array[right] == 0) {
                right--;
            } else {
                swap(array, left, right);
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
