package Array;

import java.util.*;

public class sortSpecial {
    public int[] sortSpecial(int[] A1, int[] A2) {
        if (A1 == null || A2 == null || A1.length == 0) {
            return new int[]{};
        } else if (A2.length == 0) {
            return mergeSort(A1);
        }
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < A2.length; i++) {
            dict.put(A2[i], i);
        }
        int start = 0;
        int end = A1.length - 1;
        while (start <= end) {
            if (!dict.containsKey(A1[start])) {
                swap(A1, start, end);
                end--;
            } else {
                start++;
            }
        }
        if (start == A1.length) {
            return specialSort(A1, dict);
        }
        int[] helper1 = new int[start];
        int[] helper2 = new int[A1.length - start];
        for (int i = 0; i < start; i++) {
            helper1[i] = A1[i];
        }
        for (int j = 0; j < A1.length - start; j++){
            helper2[j] = A1[start + j];
        }
        int[] res1 = specialSort(helper1, dict);
        int[] res2 = mergeSort(helper2);
        return combine(res1, res2);
    }

    public boolean isSmaller(Integer x, Integer y, Map<Integer, Integer> dict) {
        return dict.get(x) <= dict.get(y);
    }

    public void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public int[] combine(int[] a1, int[] a2) {
        int length = a1.length + a2.length;
        int[] res = new int[length];
        for (int i = 0; i < a1.length; i++) {
            res[i] = a1[i];
        }
        for (int j = 0; j < a2.length; j++) {
            res[a1.length + j] = a2[j];
        }
        return res;
    }

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
        return merge(leftside, rightside);
    }

    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        int l = left.size();
        int r = right.size();
        int ln = 0;
        int rn = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < l + r; i++) {
            if (ln < l && rn < r && left.get(ln) <= right.get(rn)) {
                res.add(left.get(ln));
                ln++;
            } else if (ln < l && rn < r && left.get(ln) > right.get(rn)) {
                res.add(right.get(rn));
                rn++;
            } else if (ln == l) {
                res.add(right.get(rn));
                rn++;
            } else {
                res.add(left.get(ln));
                ln++;
            }
        }
        return res;
    }

    public int[] specialSort(int[] array, Map<Integer, Integer> dict) {
        if(array == null || array.length == 0) {
            return new int[] {};
        }
        int left = 0;
        int right = array.length - 1;
        int a[] = new int[array.length];
        List<Integer> result = specialsort(array, left, right, dict);
        for (int i = 0; i < array.length; i++) {
            a[i] = result.get(i);
        }
        return a;
    }

    public List<Integer> specialsort(int[] a, int left, int right, Map<Integer, Integer> dict) {
        if (left == right) {
            return Arrays.asList(a[left]);
        }
        int mid = left + (right - left)/2;
        List<Integer> leftside = specialsort(a, left, mid, dict);
        List<Integer> rightside = specialsort(a, mid + 1, right, dict);
        return specialmerge(leftside, rightside, dict);
    }

    public List<Integer> specialmerge(List<Integer> left, List<Integer> right, Map<Integer, Integer> dict) {
        int l = left.size();
        int r = right.size();
        int ln = 0;
        int rn = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < l + r; i++) {
            if (ln < l && rn < r && isSmaller(left.get(ln), right.get(rn), dict)) {
                res.add(left.get(ln));
                ln++;
            } else if (ln < l && rn < r && !isSmaller(left.get(ln), right.get(rn), dict)) {
                res.add(right.get(rn));
                rn++;
            } else if (ln == l) {
                res.add(right.get(rn));
                rn++;
            } else {
                res.add(left.get(ln));
                ln++;
            }
        }
        return res;
    }
}
