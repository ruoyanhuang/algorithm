package LeetCode.Company.GoldmanSachs;

public class stringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        long res = 0;
        int index = 0;
        int positive = 1;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (str.charAt(index) == '+') {
            positive = 1;
            index++;
        } else if (str.charAt(index) == '-') {
            positive = -1;
            index++;
        }
        if (str.charAt(index) - '0' < 0 || str.charAt(index) - '0' > 9) {
            return 0;
        }
        while (index < str.length() && str.charAt(index) - '0' >= 0 && str.charAt(index) - '0' <= 9) {
            res = res * 10 + str.charAt(index) - '0';
            if (res > (long) Integer.MAX_VALUE + 1) {
                break;
            }
            index++;
        }
        res *= positive;
        if (res > (long)Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < (long)Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)res;
    }
}
