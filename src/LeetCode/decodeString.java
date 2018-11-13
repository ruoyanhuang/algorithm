package LeetCode;

public class decodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = process(s, 0, s.length() - 1);
        return sb.toString();
    }

    public StringBuilder process(String s, int start, int end) {
        int factor = 0;
        StringBuilder curr = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) - '0' >=0 && s.charAt(i) - '0' <= 9) {
                factor = factor * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) -'a' >= 0 && s.charAt(i) -'a' <= 25 || s.charAt(i) -'A' >= 0 && s.charAt(i) -'A' <= 25) {
                curr.append(s.charAt(i));
            } else {
                int j;
                int count = 0;
                for (j = i; j < s.length(); j++) {
                    if (s.charAt(j) == '[') {
                        count++;
                    } else if (s.charAt(j) == ']') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                StringBuilder tmp = process(s, i + 1, j - 1);
                for (int k = 0; k < factor; k++) {
                    curr.append(tmp);
                }
                factor = 0;
                i = j;
            }
        }
        return curr;
    }
}
