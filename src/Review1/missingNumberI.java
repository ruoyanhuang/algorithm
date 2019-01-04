package Review1;

public class missingNumberI {
    public int missing(int[] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            if (array[i] == N + 1) {
                continue;
            }
            array[Math.abs(array[i] - 1)] *= -1;
        }
        for (int j = 0; j < N; j++) {
            if (array[j] > 0) {
                return j + 1;
            }
        }
        return N + 1;
    }
}
