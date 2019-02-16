package LeetCode.Company.Amazon;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class robotObstacle {
    class point {
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public int maze(List<List<Integer>> input) {
        if (input == null || input.size() == 0) {
            return -1;
        }
        Queue<point> queue = new ArrayDeque<>();
        queue.offer(new point(0,0));
        boolean[][] visited = new boolean[input.size()][input.get(0).size()];
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                point cur = queue.poll();
                for (int[] direction : directions) {
                    int row = cur.x + direction[0];
                    int col = cur.y + direction[1];
                    if (!isOutOfBound(row, col, input.size(), input.get(0).size()) && !visited[row][col]) {
                        if (input.get(row).get(col) == 9) {
                            return level;
                        } else if (input.get(row).get(col) == 1) {
                            visited[row][col] = true;
                            queue.offer(new point(row, col));
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
