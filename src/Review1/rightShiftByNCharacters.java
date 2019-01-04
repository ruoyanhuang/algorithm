package Review1;

public class rightShiftByNCharacters {
    public String rightShift(String input, int n) {
        if (input.length() == 0) {
            return input;
        }
        n = n % input.length();
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        reverse(array, 0, n - 1);
        reverse(array, n, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
