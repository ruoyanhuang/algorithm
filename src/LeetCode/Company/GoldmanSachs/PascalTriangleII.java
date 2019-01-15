package LeetCode.Company.GoldmanSachs;

import entity.GraphNode;

import java.util.*;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for (int i = 0; i < rowIndex; i++) {
            for (int j = rowIndex; j >= 1; j--) {
                row[j] = row[j] + row[j - 1];
            }
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(row[i]);
        }
        return res;
    }
}
