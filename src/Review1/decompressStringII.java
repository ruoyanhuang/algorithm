package Review1;

public class decompressStringII {
    public String decompress(String input) {
        if (input.length() == 0) {
            return input;
        }
        int length = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            if (digit <= 9 && digit >= 0) {
                length += digit;
            }
        }
        char[] res = new char[length];
        int slow = 0;
        int fast = 0;
        while (fast < input.length()) {
            if (input.charAt(fast) - 'a' >= 0 && input.charAt(fast) - 'a' < 26) {
                if (slow == res.length) break;              //last word is 0: xxxxb2a0
                res[slow++] = input.charAt(fast++);
            } else {
                if (input.charAt(fast) - '0' == 0) {
                    slow--;
                } else {
                    for (int i = 1; i < input.charAt(fast) - '0'; i++) {
                        res[slow] = res[slow - 1];
                        slow++;
                    }
                }
                fast++;
            }
        }
        return new String(res);
    }
}
