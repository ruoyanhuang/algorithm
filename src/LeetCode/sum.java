package LeetCode;

public class sum {
    public int findallsum(int[] array, int target) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        return recursion(array, target, 1, count);
    }

    public int recursion(int[] array, int target, int layer, int count) {
        if (layer == array.length) {
            return target == 0 ? 1 : 0;
        }

    }
}
