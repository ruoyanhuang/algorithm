package Review1;

import entity.GraphNode;

import java.util.*;

public class bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        Map<GraphNode, Integer> map = new HashMap<>();
        boolean res = true;
        for (GraphNode n : graph) {
            res &= bfs(n, map);
        }
        return res;
    }

    private boolean bfs(GraphNode node, Map<GraphNode, Integer> map) {
        if (map.get(node) != null) {
            return true;
        }
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node, 1);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int color = map.get(cur);
            int nextcolor = color * -1;
            for (GraphNode gn :cur.neighbors) {
                if (map.get(gn) == null) {
                    queue.offer(gn);
                    map.put(gn, nextcolor);
                } else if (map.get(gn) == color) {
                    return false;
                }
            }
        }
        return true;
    }
}
