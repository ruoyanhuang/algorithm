package LeetCode.FaceBook;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class isGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean res = true;
        for (int i = 0; i < graph.length; i++) {
            res &= bfs(graph, i, map);
        }
        return res;
    }

    public boolean bfs(int[][] graph, int start, Map<Integer, Integer> map) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        int color = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (!map.containsKey(cur)) {
                    map.put(cur, color);
                    for (int j = 0; j < graph[cur].length; j++) {
                        queue.offer(graph[cur][j]);
                    }
                } else if (map.get(cur) != cur) {
                    return false;
                }
            }
            color = -1 * color;
        }
        return true;
    }
}
