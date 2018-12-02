package Graph;

import java.util.ArrayList;
import java.util.List;

public class subSets {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (set == null) {
            return res;
        } else if (set.length() == 0) {
            res.add(sb.toString());
            return res;
        }
        return dfs(0, set, sb, res);
    }

    public List<String> dfs(int index, String set, StringBuilder sb, List<String> res) {
        if (index == set.length()) {
            res.add(sb.toString());
        }
        sb.append(set.charAt(index));
        dfs(index + 1, set, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        dfs(index + 1, set, sb, res);
        return res;
    }
}
