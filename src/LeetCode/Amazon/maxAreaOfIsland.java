package LeetCode.Amazon;

public class maxAreaOfIsland {
    public static int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int globalmax = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (grid[i][j] == 1) {
                        int[] res = new int[]{0};
                        traverse(grid, visited, i, j, res);
                        globalmax = Math.max(globalmax, res[0]);
                    }
                }
            }
        }
        return globalmax;
    }

    public void traverse(int[][] grid, boolean[][] visited, int i, int j, int[] res) {
        if (outOfBound(i, j, grid.length, grid[0].length)) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        res[0]++;
        for (int[] direction : directions) {
            traverse(grid, visited, i + direction[0], j + direction[1], res);
        }
    }

    public boolean outOfBound(int i, int j, int row, int col) {
        return i < 0 || i >= row || j < 0 || j >= col;
    }
}
