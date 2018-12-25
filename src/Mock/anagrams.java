package Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class anagrams {
    public List<String> allAnagram(String[] dict, String input) {
        List<String> res = new ArrayList<>();
        String[] copy = new String[dict.length];
        for (int i = 0; i < dict.length; i++) {
            copy[i] = sortString(dict[i]);
        }
        input = sortString(input);
        for (int i = 0; i < copy.length; i++) {
            if (input.equals(copy[i])) {
                res.add(dict[i]);
            }
        }
        return res;
    }

    private String sortString(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return array.toString();
    }
}
