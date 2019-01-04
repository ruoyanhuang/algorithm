package Review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allSubsetsII {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        dfs(array, 0, sb, res);
        return res;
    }

    private void dfs(char[] array, int index, StringBuilder sb, List<String> res) {
        if (index == array.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(array[index]);
        dfs(array, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        while (index < array.length - 1 && array[index] == array[index + 1]) {  //if skip array[index], skip all same char to array[index]
            index++;
        }
        dfs(array, index + 1, sb, res);
    }
}
