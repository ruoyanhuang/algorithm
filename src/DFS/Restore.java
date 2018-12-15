package DFS;

import java.util.ArrayList;
import java.util.List;

public class Restore {
    public List<String> restore(String ip) {
        if (ip == null || ip.length() < 4 || ip.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> position = new ArrayList<>();
        dfs(ip, -1, 4, res, position);
        return res;
    }

    public void dfs(String ip, int index, int count, List<String> res, List<Integer> position) {
        if (index == ip.length() - 1) {
            if (count == 0) {
                construct(ip, res, position);
            }
            return;
        }
        for (int i = index + 1; i < index + 4 && i < ip.length(); i++) {
            if (isValid(ip, index, i)) {
                position.add(i);
                dfs(ip, i, --count, res, position);
                position.remove(position.size() - 1);
                count++;
            }
        }
    }

    public boolean isValid(String ip, int last, int index) {
        if (index - last > 1 && ip.charAt(last + 1) == '0') {
            return false;
        }
        int i = Integer.parseInt(ip.substring(last + 1, index + 1));
        return i >=0 && i <= 255;
    }

    public void construct(String ip, List<String> res, List<Integer> position) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < position.size(); i++) {
            int p = position.get(i);
            while (start <= p) {
                sb.append(ip.charAt(start));
                start++;
            }
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        res.add(sb.toString());
    }
}
