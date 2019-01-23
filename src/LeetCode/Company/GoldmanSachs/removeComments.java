package LeetCode.Company.GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class removeComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            char[] array = source[i].toCharArray();
            if (!inBlock) {
                sb = new StringBuilder();
            }
            for (int j = 0; j < array.length; j++) {
                if (!inBlock && j < array.length - 1 && array[j] == '/' && array[j + 1] == '*') {
                    inBlock = true;
                    j++;
                } else if (inBlock && j < array.length - 1 && array[j] == '*' && array[j + 1] == '/') {
                    inBlock = false;
                    j++;
                } else if (!inBlock && j < array.length - 1 && array[j] == '/' && array[j + 1] == '/') {
                    break;
                } else if (!inBlock) {
                    sb.append(array[j]);
                }
            }
            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
            }
        }
        return res;
    }
}
