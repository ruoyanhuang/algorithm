package LeetCode.Topic.DFS;

public class longestIncreasingPathInMatrix {
    public static final int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] visited = new int[matrix.length][matrix[0].length];
        int globalmax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                globalmax = Math.max(globalmax, dfs(matrix, visited, i, j));
            }
        }
        return globalmax;
    }

    private int dfs(int[][] matrix, int[][] visited, int x, int y) {
        if (visited[x][y] != 0) {
            return visited[x][y];
        }
        for (int[] direction : directions) {
            int row = x + direction[0];
            int col = y + direction[1];
            if (!isOutOfBound(row, col, matrix.length, matrix[0].length) && matrix[row][col] > matrix[x][y]) {
                visited[x][y] = Math.max(visited[x][y], dfs(matrix, visited, row, col));
            }
        }
        visited[x][y] += 1;
        return visited[x][y];
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
