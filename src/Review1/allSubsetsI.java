package Review1;

import java.util.ArrayList;
import java.util.List;

public class allSubsetsI {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(set, 0, res, sb);
        return res;
    }

    private void dfs(String set, int index, List<String> res, StringBuilder sb) {
        if (index == set.length()) {
            res.add(sb.toString());
            return;
        }
        sb.append(set.charAt(index));
        dfs(set, index +1, res, sb);
        sb.deleteCharAt(sb.length() - 1);
        dfs(set, index + 1, res, sb);
    }
}
