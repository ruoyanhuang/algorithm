package LeetCode.Topic.DFS;

import java.util.ArrayList;
import java.util.List;

public class removeBoxes {
    public int removeBoxes(int[] boxes) {
        List<Integer>box = new ArrayList<>();
        for (int i = 0; i < boxes.length; i++) {
            box.add(boxes[i]);
        }
        int[] max = new int[]{0};
        dfs(box, 0, max);
        return max[0];
    }

    private void dfs(List<Integer> box, int sum, int[] max) {
        if (box.size() == 0) {
            max[0] = Math.max(max[0], sum);
            return;
        }
        List<Integer> index = new ArrayList<>();
        index.add(0);
        for (int i = 1; i <box.size(); i++) {
            if (box.get(i) != box.get(i - 1)) {
                index.add(i);
            }
        }
        for (int i : index) {
            List<Integer> newbox = construct(box, i);
            sum += getSum(box, i);
            dfs(newbox, sum, max);
        }
    }

    private List<Integer> construct(List<Integer> box, int index) {
        List<Integer> newbox = new ArrayList<>();
        for (int i = 0; i < box.size(); i++) {
            if (i == index) {
                while (i < box.size() && box.get(i) == box.get(index)) {
                    i++;
                }
            }
            newbox.add(box.get(i));
        }
        return newbox;
    }

    private int getSum(List<Integer> box, int index) {
        int count = 0;
        int start = index;
        while (box.get(start) == box.get(index)) {
            count++;
            start++;
        }
        return count * count;
    }
}
