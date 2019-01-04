package LeetCode.Topic.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class pacificAtlanticWaterFlow {
    class point{
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                bfs(matrix, i, j, res, new boolean[]{false, false});
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, int x, int y, List<int[]> res, boolean[] arrive) {
        Queue<point> queue = new ArrayDeque<>();
        queue.offer(new point(x,y));
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            point cur = queue.poll();
            for (int[] direction : directions) {
                int row = cur.x + direction[0];
                int col = cur.y + direction[1];
                if (!isOutOfBound(row, col, matrix.length, matrix[0].length) && !visited[row][col]) {
                    if (matrix[row][col] <= matrix[cur.x][cur.y]) {
                        queue.offer(new point(row,col));
                        visited[row][col] = true;
                    }
                    if (row == 0 && col == 0) {
                        arrive[0] = true;
                    }
                    if (row == matrix.length && col == matrix[0].length) {
                        arrive[1] = true;
                    }
                }
            }
            if (arrive[0] && arrive[1]) {
                res.add(new int[]{x,y});
            }
        }
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
