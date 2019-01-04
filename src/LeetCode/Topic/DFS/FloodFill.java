package LeetCode.Topic.DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
    class point{
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<point> queue = new ArrayDeque<>();
        queue.offer(new point(sr, sc));
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            point cur = queue.poll();
            for (int[] direction : directions) {
                int row = cur.x + direction[0];
                int col = cur.y + direction[1];
                if (!isOutOfBound(row, col, image.length, image[0].length) && !visited[row][col]) {
                    if (image[row][col] == image[cur.x][cur.y]) {
                        queue.offer(new point(row, col));
                        visited[row][col] = true;
                    }
                }
            }
            image[cur.x][cur.y] = newColor;
        }
        return image;
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
