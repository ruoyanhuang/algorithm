package CrossTraining;

import java.util.Arrays;

public class arrayDeduplicationIII {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        int fast = 1;
        while (fast < array.length) {
            if (slow == -1) {
                array[++slow] = array[fast++];
            } else if (array[fast] == array[slow]) {
                while (fast < array.length && array[fast] == array[slow]) {
                    fast++;
                }
                slow--;
            } else {
                array[++slow] = array[fast++];
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }
}
