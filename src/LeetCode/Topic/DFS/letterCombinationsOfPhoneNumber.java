package LeetCode.Topic.DFS;

import java.util.ArrayList;
import java.util.List;

public class letterCombinationsOfPhoneNumber {
    private static String[] panel = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb, res);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String tmp = panel[digit];
        for (int i = 0; i < tmp.length(); i++) {
            sb.append(tmp.charAt(i));
            dfs(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
