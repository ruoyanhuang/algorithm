package LeetCode.Topic.DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class minesweeper {
    class point {
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] directions = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<point> queue = new ArrayDeque<>();
        queue.offer(new point(click[0], click[1]));
        while (!queue.isEmpty()) {
            point cur = queue.poll();
            if (board[cur.x][cur.y] == 'M') {
                board[cur.x][cur.y] = 'X';
                return board;
            } else if (isNumber(board, cur.x, cur.y) > 0) {
                int count = isNumber(board, cur.x, cur.y);
                board[cur.x][cur.y] = (char) (count + '0');
                return board;
            } else {
                board[cur.x][cur.y] = 'B';
                for (int[] direction : directions) {
                    int row = cur.x + direction[0];
                    int col = cur.y + direction[1];
                    if (!isOutOfBound(row, col, board.length, board[0].length)) {
                        int count = isNumber(board, row, col);
                        if (board[row][col] == 'M') {
                            board[row][col] = 'X';
                        } else if (board[row][col] == 'E' && count > 0) {
                            board[row][col] = (char) (count + '0');
                        } else if (board[row][col] == 'E') {
                            queue.offer(new point(row, col));
                            board[row][col] = 'B';
                        }
                    }
                }
            }
        }
        return board;
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    private int isNumber(char[][] board, int x, int y) {
        int count = 0;
        for (int[] direction : directions) {
            int row = x + direction[0];
            int col = y + direction[1];
            if (!isOutOfBound(row, col, board.length, board[0].length) && board[row][col] == 'M') {
                count++;
            }
        }
        return count;
    }
}
