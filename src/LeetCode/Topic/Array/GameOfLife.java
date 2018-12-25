package LeetCode.Topic.Array;

public class GameOfLife {
    private static final int[][] directions = new int[][]{{-1,-1}, {0,-1}, {1,-1}, {-1,0}, {1,0}, {-1,1}, {0,1}, {1,1}};

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int countOne = 0;
                for (int k = 0; k < directions.length; k++) {
                    int row = i + directions[k][0];
                    int col = j + directions[k][1];
                    if (!isOutOfBound(row, col, board.length, board[0].length)) {
                        if (board[row][col] == 1 || board[row][col] == -1) {
                            countOne++;
                        }
                    }
                }
                if (board[i][j] == 0 && countOne == 3) {
                    board[i][j] = -2;
                }
                if (board[i][j] == 1 && (countOne < 2 || countOne > 3)) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
