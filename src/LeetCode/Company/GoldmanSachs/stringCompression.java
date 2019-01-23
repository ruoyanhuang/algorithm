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
                    fast++;
                    count++;
                }
                String s = String.valueOf(count);
                for (int i = 0; i < s.length(); i++) {
                    chars[++slow] = s.charAt(i);
                }
                if (fast < chars.length) {
                    chars[++slow] = chars[fast++];      //"aa22" --> "a23" should be "a222"
                }
            }
        }
        return slow + 1;
    }
}
