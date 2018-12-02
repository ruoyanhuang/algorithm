package String;

public class rightShift {
    public String rightShift(String input, int n) {
        if (input == null || input.length() == 0 || n % input.length() == 0) {
            return input;
        }
        n = n % input.length();
        char[] array = input.toCharArray();
        reverse(array, 0 , array.length - 1);
        reverse(array, 0, n - 1);
        reverse(array, n, array.length - 1);
        return new String(array);
    }

    public void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
