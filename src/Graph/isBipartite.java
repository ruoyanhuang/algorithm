package Graph;

import entity.GraphNode;

import java.util.*;

public class isBipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        Map<GraphNode, Integer> isVisited = new HashMap<>();
        for (GraphNode node : graph) {
            if (helper(node, isVisited) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean helper(GraphNode node, Map<GraphNode, Integer> isVisited) {
        if (isVisited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        isVisited.put(node, 1);
        while (!queue.isEmpty()) {
            GraphNode curnode = queue.poll();
            int curval = isVisited.get(curnode);
            int nextval = curval == 1 ? -1 : 1;
            for (GraphNode gn : curnode.neighbors) {
                if (!isVisited.containsKey(gn)) {
                    queue.offer(gn);
                    isVisited.put(gn, nextval);
                } else if (isVisited.get(gn) != nextval) {
                    return false;
                }
            }
        }
        return true;
    }
}
