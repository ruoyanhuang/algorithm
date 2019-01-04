package LeetCode.Topic.DFS;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        Integer[] array = new Integer[n];
        List<Integer[]> binary = new ArrayList<>();
        dfs(array, 0, binary);
        construct(binary, res);
        return res;
    }

    private void dfs(Integer[] array, int index, List<Integer[]> binary) {
        if (index == array.length) {
            binary.add(array);
            return;
        }
        array[index] = 1;
        dfs(array, index + 1, binary);
        array[index] = 0;
        dfs(array, index + 1, binary);
    }

    private void construct(List<Integer[]> binary, List<Integer> res) {
        for (Integer[] array : binary) {
            int sum = 0;
            for (int i = array.length - 1; i >= 0; i--) {
                sum += (int) Math.pow(2, array.length - 1 - i) * array[i];
            }
            res.add(sum);
        }
    }
}
