package LeetCode.DP;

import java.util.HashMap;
import java.util.Map;

public class longestPrint {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> path = new HashMap<>();
        int globalmax = 0;
        for (int i = 1; i < array.length; i++) {
            int curmax = 0;
            for (int j = 0; j < i; j++) {
                if ((j == 0 || path.get(j) > 1) && array[i] > array[j]) {
                    curmax = Math.max(curmax, path.get(j));
                }
                path.put(i, curmax);
                globalmax = Math.max(globalmax, path.get(i));
            }
        }
        return globalmax;
    }
}
