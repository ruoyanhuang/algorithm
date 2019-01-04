package Review1;

import java.util.Arrays;

public class reverseString {
    public String reverse(String input) {
        char[] array = input.toCharArray();
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
