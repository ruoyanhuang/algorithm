package LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Tree{
    int height;
    int distance;
    public Tree(int height, int distance) {
        this.height = height;
        this.distance = distance;
    }
}

public class cutOffTree {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Tree> path = new PriorityQueue<>(new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return o1.height - o2.height;
            }
        });
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j ++) {
                if (forest.get(i).get(j) > 1) {
                    int distance = bfs(0, 0, forest.get(i).get(j), forest, 0);
                    if (distance >= 0) {
                        path.offer(new Tree(forest.get(i).get(j), distance));
                    } else {
                        return -1;
                    }
                }
            }
        }
        int res = 0;
        while (path.size() > 0) {
            res += path.poll().distance;
        }
        return res;
    }

    public int bfs(int row, int col, int end, List<List<Integer>> forest, int distance) {
        if (forest.get(row).get(col) == end) {
            return distance;
        }
        if (row > 0 && forest.get(row-1).get(col) > 0) {
            bfs(row - 1, col, end, forest, ++distance);
        }
        if (row < forest.size() - 1 && )
        return -1;
    }
}
