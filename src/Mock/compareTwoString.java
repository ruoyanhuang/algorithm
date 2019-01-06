package Mock;

import java.util.Arrays;

public class compareTwoString {
    public boolean isTwoStringSame(String s1, String s2) {
        char delete = '/';
        if (s1.charAt(0) == delete || s2.charAt(0) == delete) {
            return false;
        }
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int end1 = 0;
        int end2 = 0;
        for (int i = 1; i < array1.length; i++) {
            if (end1 == -1 || array1[i] != delete) {
                if (end1 == -1 && array1[i] == delete) {
                    return false;
                }
                array1[++end1] = array1[i];
            } else {
                end1--;
            }
        }
        for (int j = 1; j < array2.length; j++) {
            if (end2 == -1 || array2[j] != delete) {
                if (end2 == -1 && array2[j] == delete) {
                    return false;
                }
                array2[++end2] = array2[j];
            } else {
                end2--;
            }
        }
        if (end1 == -1 || end2 == -1) {
            return end1 == end2;
        }
        String ns1 = new String(array1, 0, end1 + 1);
        String ns2 = new String(array2, 0, end2 + 1);
        return ns1.equals(ns2);
    }
}
