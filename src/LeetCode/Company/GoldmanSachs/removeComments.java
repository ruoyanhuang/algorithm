package LeetCode.Company.GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class removeComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean blockComment = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            char[] array = source[i].toCharArray();
            if (!blockComment) {
                sb = new StringBuilder();
            }
            for (int j = 0; j < array.length; j++) {
                if (!blockComment && j < array.length - 1 && array[j] == '/' && array[j + 1] == '*') {
                    blockComment = true;
                    j++;
                }else if (blockComment && j < array.length - 1 && array[j] == '*' && array[j + 1] == '/') {
                    blockComment = false;
                    j++;
                }else if (!blockComment && j < array.length - 1 && array[j] == '/' && array[j + 1] == '/') {
                    break;
                } else if (!blockComment) {
                    sb.append(array[j]);
                }
            }
            if (!blockComment && sb.length() != 0) {
                res.add(sb.toString());
            }
        }
        return res;
    }
}
