package LeetCode.Company.Amazon;

public class wordSearchI {
    public static int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean valid = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    valid = valid || dfs(board, word, 0, 0, 0, visited);
                    if (valid == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        boolean tmp = false;
        for (int i = 0; i < directions.length; i++) {
            int x = row + directions[i][0];
            int y = col + directions[i][1];
            if (!isOutOfBound(x, y, board.length, board[0].length) && !visited[x][y]) {
                visited[x][y] = true;
                tmp = tmp || dfs(board, word, x, y, index + 1, visited);
                visited[x][y] = false;
            }
        }
        return tmp;
    }

    public boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
