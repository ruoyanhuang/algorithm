package Bit;

public class diffBits {
    public int diffBits(int a, int b) {
        int count = 0;
        int target = a ^ b;
        for (int i = 0; i < 31; i++) {
            if ((target & 1) == 1) {
                count++;
            }
            target = target >> 1;
        }
        return count;
    }
}
