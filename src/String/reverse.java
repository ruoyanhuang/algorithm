package String;

public class reverse {
    public String reverse(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return new String(array);
    }
}
