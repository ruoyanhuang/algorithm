package RecursionSort;

public class fibonacci {
    public long fibonacci(int K) {
        if (K <= 0) {
            return 0;
        }
        if (K == 1) {
            return 1;
        }
        return fibonacci(K - 1) + fibonacci( K - 2);
    }
}
