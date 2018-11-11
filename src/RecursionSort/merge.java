package RecursionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {
    public int[] mergeSort(int[] array) {
        if(array == null || array.length == 0) {
            return new int[] {};
        }
        int left = 0;
        int right = array.length - 1;
        int a[] = new int[array.length];
        List<Integer> result = sort(array, left, right);
        for (int i = 0; i < array.length; i++) {
            a[i] = result.get(i);
        }
        return a;
    }

    public List<Integer> sort(int[] a, int left, int right) {
        if (left == right) {
            return Arrays.asList(a[left]);
        }
        int mid = left + (right - left)/2;
        List<Integer> leftside = sort(a, left, mid);
        List<Integer> rightside = sort(a, mid + 1, right);
        return combine(leftside, rightside);
    }

    public List<Integer> combine(List<Integer> left, List<Integer> right) {
        int l = left.size();
        int r = right.size();
        int ln = 0;
        int rn = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < l + r; i++) {
            if (ln < l && rn < r && left.get(ln) <= right.get(rn)) {
                result.add(left.get(ln));
                ln++;
            } else if (ln < l && rn < r && left.get(ln) > right.get(rn)) {
                result.add(right.get(rn));
                rn++;
            } else if (ln == l) {
                result.add(right.get(rn));
                rn++;
            } else {
                result.add(left.get(ln));
                ln++;
            }
        }
        return result;
    }
}
