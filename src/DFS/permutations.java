package DFS;

import java.util.ArrayList;
import java.util.List;

public class permutations {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        } else if (set.length() == 0) {
            res.add("");
            return res;
        }
        StringBuilder sbset = new StringBuilder(set);
        dfs(sbset, 0, res);
        return res;
    }

    public void dfs(StringBuilder sbset, int level, List<String> res) {
        if (level == sbset.length()) {
            res.add(sbset.toString());
            return;
        }
        for (int i = level; i < sbset.length(); i++) {
            sbset = swap(sbset, level, i);
            dfs(sbset, level + 1, res);
            sbset = swap(sbset, level, i);
        }
    }

    public StringBuilder swap(StringBuilder sb, int start, int end) {
        char tmp = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, tmp);
        return sb;
    }
}
