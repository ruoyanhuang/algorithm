package LeetCode.Company.Amazon;

public class factorial {
    public int preimageSizeFZF(int K) {
        long lo = K;
        long hi = new Long(5 * K + 1);
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (zeta(mid) == K) {
                return 5;
            } else if (zeta(mid) < K) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public long zeta(long x) {
        if (x == 0) {
            return 0;
        }
        return x / 5 + zeta(x / 5);
    }
}
