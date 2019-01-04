package Review1;

public class determineStringIsSubstring {
    public int strstr(String large, String small) {
        if (small.length() == 0) {
            return 0;
        }
        if (large.length() < small.length()) {
            return -1;
        }
        for (int i = 0; i < large.length(); i++) {
            if (large.charAt(i) == small.charAt(0)) {
                int res = isMatch(large, small, i);
                if (res != -1) {
                    return res;
                }
            }
        }
        return -1;
    }

    private int isMatch(String large, String small, int index) {
        int l = index;
        int s = 0;
        while (l < large.length() && s < small.length()) {
            if (large.charAt(l) == small.charAt(s)) {
                l++;
                s++;
            } else {
                return -1;
            }
        }
        if (s < small.length()) {
            return -1;
        } else {
            return index;
        }
    }
}
