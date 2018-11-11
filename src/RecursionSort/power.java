package RecursionSort;

public class power {
    public long power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        long tmp = power (a, b/2);
        if (b % 2 == 0){
            return tmp * tmp;
        } else {
            return a * tmp * tmp;
        }
    }
}
