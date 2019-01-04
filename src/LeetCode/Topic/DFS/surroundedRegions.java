package LeetCode.Topic.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class surroundedRegions {
    class point{
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    bfs(board, i, j, visited);
                }
            }
        }
    }

    public void bfs(char[][] board, int x, int y, boolean[][] visited) {
        Queue<point> queue = new ArrayDeque<>();
        queue.offer(new point(x, y));
        List<point> area = new ArrayList<>();
        area.add(new point(x, y));
        visited[x][y] = true;
        boolean isSurrounded = !isOnBound(x, y, board.length, board[0].length);
        while (!queue.isEmpty()) {
            point cur = queue.poll();
            for (int[] direction : directions) {
                int row = cur.x + direction[0];
                int col = cur.y + direction[1];
                if (!isOutOfBound(row, col, board.length, board[0].length) && board[row][col] == 'O' && !visited[row][col]) {
                    if (isOnBound(row, col, board.length, board[0].length)) {
                        isSurrounded = false;
                    }
                    visited[row][col] = true;
                    queue.offer(new point(row, col));
                    area.add(new point(row, col));
                }
            }
        }
        if (isSurrounded) {
            reverse(board, area);
        }
    }

    public boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    public boolean isOnBound(int x, int y, int row, int col) {
        return x == 0 || x == row - 1 || y == 0 || y == col - 1;
    }

    private void reverse(char[][] board, List<point> area) {
        for (point p : area) {
            board[p.x][p.y] = 'X';
        }
    }
}
