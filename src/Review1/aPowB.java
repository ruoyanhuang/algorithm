package Review1;

public class aPowB {
    public long power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        long res = power(a, b/2);
        if (b % 2 == 0) {
            return res * res;
        } else {
            return res * res * a;
        }
    }
}
