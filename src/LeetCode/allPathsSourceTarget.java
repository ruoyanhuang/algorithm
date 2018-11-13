package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class allPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        dfs(0, graph, res, path);
        return res;
    }

    public void dfs(int root, int[][] graph, List<List<Integer>> res, List<Integer> path) {
        if (graph[root].length == 0) {
            if (root == graph.length - 1) {
                res.add(new ArrayList<>(path)); //Why new ArrayList not path?
            }
            return;
        }
        for (int child : graph[root]) {
            path.add(child);
            dfs(child, graph, res, path);
            path.remove(path.size()-1); //Why path.size()-1 not child?
        }
    }
}
