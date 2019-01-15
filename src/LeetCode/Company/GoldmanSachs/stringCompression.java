package LeetCode.Company.GoldmanSachs;

public class stringCompression {
    public int compress(char[] chars) {
        int slow = 0;
        int fast = 1;
        while (fast < chars.length) {
            if (chars[fast] != chars[fast - 1]) {
                chars[++slow] = chars[fast++];
            } else {
                int count = 1;
                while (fast < chars.length && chars[fast] == chars[fast - 1]) {
                    count++;
                    fast++;
                }
                String digit = String.valueOf(count);
                for (int i = 0; i < digit.length(); i++) {
                    chars[++slow] = digit.charAt(i);
                }
                if (fast < chars.length) {
                    chars[++slow] = chars[fast];
                }
                fast++;
            }
        }
        return slow + 1;
    }
}
