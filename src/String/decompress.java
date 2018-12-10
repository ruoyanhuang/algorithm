package String;

public class decompress {
    public String decompress(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        int length = 0;
        int num = 0;
        while (num < input.length()) {
            if (input.charAt(num) - '0' >= 0 && input.charAt(num) - '0' <= 9) {
                length += input.charAt(num) - '0';
            }
            num++;
        }
        char[] array = new char[length];
        int fast = 0;
        int slow = 0;
        while (fast < input.length()) {
            if (input.charAt(fast) - 'a' >= 0 && input.charAt(fast) - 'a' < 26 || input.charAt(fast) - 'A' >= 0 && input.charAt(fast) - 'A' < 26) {
                if (slow == length) {
                    break;
                }
                array[slow] = input.charAt(fast);
                fast++;
                slow++;
            } else if (input.charAt(fast) - '0' == 0) {
                slow--;
                fast++;
            } else if (input.charAt(fast) - '0' == 1) {
                fast++;
            } else {
                for (int i = 0; i < input.charAt(fast) - '0' -1; i++) {
                    array[slow] = array[slow - 1];
                    slow++;
                }
                fast++;
            }
        }
        return new String(array);
    }
}
