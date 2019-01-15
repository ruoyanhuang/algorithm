package LeetCode.Topic.Recursion;

import java.util.ArrayList;
import java.util.List;

public class strobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        char[] array = new char[n];
        recursion(array, 0, array.length - 1, res);
        return res;
    }

    private void recursion(char[] array, int left, int right, List<String> res) {
        if (left > right) {
            res.add(new String(array));
            return;
        }
        array[left] = '1';
        array[right] = '1';
        recursion(array, left + 1, right - 1, res);
        array[left] = '8';
        array[right] = '8';
        recursion(array, left + 1, right - 1, res);
        if (left == 0 && right == 0 || left > 0) {
            array[left] = '0';
            array[right] = '0';
            recursion(array, left + 1, right - 1, res);
        }
        if (left != right) {
            array[left] = '6';
            array[right] = '9';
            recursion(array, left + 1, right - 1, res);
            array[left] = '9';
            array[right] = '6';
            recursion(array, left + 1, right - 1, res);
        }
    }
}
