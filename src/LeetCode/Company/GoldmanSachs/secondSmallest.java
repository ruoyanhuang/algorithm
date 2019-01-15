package LeetCode.Company.GoldmanSachs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class secondSmallest {
    public int findSecondSmallest(int[] array) {
        if (array.length < 2) {
            return -1;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int globalMin = divide(array, 0, array.length - 1, map);
        int res = Integer.MAX_VALUE;
        for (int i : map.get(globalMin)) {
            res = Math.min(res, i);
        }
        return res;
    }

    private int divide(int[] array, int left, int right, Map<Integer, List<Integer>> map) {
        if (left >= right) {
            map.put(array[left], new ArrayList<>());
            return array[left];
        }
        int mid = left + (right - left) / 2;
        int leftMin = divide(array, left, mid, map);
        int rightMin = divide(array, mid + 1, right, map);
        if (leftMin < rightMin) {
            map.get(leftMin).add(rightMin);
            return leftMin;
        } else {
            map.get(rightMin).add(leftMin);
            return rightMin;
        }
    }
}
