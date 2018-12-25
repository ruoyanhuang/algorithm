//package Mock;
//
//import entity.GraphNode;
//import entity.ListNode;
//
//import java.util.*;
//
//public class shorestCycle {
//    public List<GraphNode> findShorestPath(List<GraphNode> graph, GraphNode target) {
//        List<GraphNode> res = new ArrayList<>();
//        if (graph == null || target == null) {
//            return res;
//        }
//        Set<GraphNode> visited = new HashSet<>();
//        List<GraphNode> path = new ArrayList<>();
//        dfs(target, target, path, visited, res);
//    }
//
//    public void dfs(GraphNode target, GraphNode current, List<GraphNode> path, Set<GraphNode> visited, List<GraphNode> res) {
//        if (current == target) {
//            res.add(current);
//            return;
//        }
//        for (GraphNode node : current.neighbors) {
//            if (visited.add(node)) {
//                path.add(node);
//                dfs(target, node, path, visited, res);
//                path.remove(node);
//            }
//        }
//    }
//}
