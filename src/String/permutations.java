package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permutations {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null || set.length() == 0) {
            res.add(set);
            return res;
        }
        char[] array = set.toCharArray();
        dfs(array, 0, res);
        return res;
    }

    public void dfs(char[] array, int index, List<String> res) {
        if (index == array.length - 1) {
            res.add(new String(array));
            return;
        }
        Set<Character> dedup = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (dedup.contains(array[i])) {
                swap(array, index, i);
                dfs(array, index + 1, res);
                dedup.add(array[i]);
                swap(array, index, i);
            }
        }
    }

    public void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
