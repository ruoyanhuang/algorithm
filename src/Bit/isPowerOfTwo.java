package Bit;

public class isPowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        int count = 1;
        while (number > 0) {
            if ((number & 1) == 1) {
                count--;
            }
            number = number >> 1;
        }
        return count == 0;
    }
}
