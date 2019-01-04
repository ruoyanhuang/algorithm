package LeetCode.Topic.DFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class friendCircles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
            }
            for (int j = i; j < n; j++) {
                if (M[i][j] == 1 && !visited.contains(j)) {
                    visited.add(j);
                    queue.offer(j);
                }
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int k = cur; k < n; k++) {
                    if (M[i][k] == 1 && !visited.contains(k)) {
                        visited.add(k);
                        queue.offer(k);
                    }
                }
            }
        }
        return count;
    }
}
