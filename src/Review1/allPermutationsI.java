package Review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allPermutationsI {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        dfs(array, 0, res);
        return res;
    }

    private void dfs(char[] array, int index, List<String> res) {
        if (index == array.length) {
            res.add(new String(array));             //cannot use Arrays.toString() here
        }
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            dfs(array, index + 1, res);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
