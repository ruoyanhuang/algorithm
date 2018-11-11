package String;

import java.util.HashMap;

public class missingNumber {
    public int missing(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int target = 0;
        HashMap<Integer, Integer> missing = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (missing.containsKey(array[i])) {
                missing.put(array[i], missing.get(array[i]) + 1);
            } else {
                missing.put(array[i], 1);
            }
        }
        for (int j = 1; j <= array.length + 1; j++) {
            if (missing.get(j) == null) {
                target = j;
            }
        }
        return target;
    }
}
