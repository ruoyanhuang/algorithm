package String;

public class strstr {
    public int strstr(String large, String small) {
        if (large == null || small == null || large.length() == 0) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        for (int i = 0; i < large.length() - small.length() + 1; i++) {
            int j;
            for (j = 0; j < small.length(); j++) {
                if (large.charAt(i + j) != small.charAt(j)) {
                    break;
                }
            }
            if (j == small.length()) {
                return i;
            }
        }
        return -1;
    }
}
