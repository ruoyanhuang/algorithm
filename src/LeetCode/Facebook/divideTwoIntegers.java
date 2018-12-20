package LeetCode.FaceBook;

public class divideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }
        if (dividend == 0) {
            return 0;
        }
        int factor;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            factor = 1;
        } else {
            factor = -1;
        }
        dividend = dividend < 0 ? dividend : -1 * dividend;
        divisor = divisor < 0 ? divisor : -1 * divisor;
        int res = recursion(dividend, divisor);
        return factor * res;
    }

    public int recursion(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int d = divisor;
        int count = 1;
        while (dividend <= d + d) {
            d = d + d;
            count = count + count;
        }
        return count + recursion(dividend - divisor, divisor);
    }
}
