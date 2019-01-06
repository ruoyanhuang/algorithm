package CrossTraining;

public class arrayDeduplicationI {
    public int[] dedup(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }
            fast++;
        }
        int[] res = new int[slow + 1];
        for (int i = 0; i <= slow; i++) {
            res[i] = array[i];
        }
        return res;
    }
}
