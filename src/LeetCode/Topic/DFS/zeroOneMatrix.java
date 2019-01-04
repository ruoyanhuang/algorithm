package LeetCode.Topic.DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class zeroOneMatrix {
    class point{
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = nearestZero(matrix, i, j);
            }
        }
        return res;
    }

    private int nearestZero(int[][] matrix, int x, int y) {
        int level = 0;
        if (matrix[x][y] == 0) {
            return level;
        }
        Queue<point> queue = new ArrayDeque<>();
        queue.offer(new point(x,y));
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                point cur = queue.poll();
                for (int[] direction : directions) {
                    int row = cur.x + direction[0];
                    int col = cur.y + direction[1];
                    if (!isOutOfBound(row, col, matrix.length, matrix[0].length)) {
                        if (matrix[row][col] == 0) {
                            return level;
                        }
                        queue.offer(new point(row,col));
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
