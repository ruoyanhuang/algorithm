package DFS;

import java.util.ArrayList;
import java.util.List;

public class subSets {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        } else if (set.length() == 0) {
            res.add(set);
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(set, 0, sb, res);
        return res;
    }

    public void dfs(String set, int index, StringBuilder sb, List<String> res) {
        if (index == set.length()) {
            res.add(sb.toString()); //res.add(new String(sb));???
            return;
        }
        sb.append(set.charAt(index));
        dfs(set, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        while (index < set.length() - 1 && set.charAt(index + 1) == set.charAt(index)) {
            index++;
        }
        dfs(set, ++index, sb, res);
    }
}
