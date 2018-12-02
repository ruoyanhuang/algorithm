package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class spiral {
    public List<Integer> spiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int N = matrix.length;
        boolean[][] isVisited = new boolean[N][N];
        int row = 0;
        int col = 0;
        List<Integer> res = new ArrayList<>();
        while (res.size() < N * N) {
            col = right(row, ++col, matrix, isVisited, res);
            row = down(++row, col, matrix, isVisited, res);
            col = left(row, --col, matrix, isVisited, res);
            row = up(--row, col, matrix, isVisited, res);
        }
        return res;
    }

    public int right(int row, int col, int[][] matrix, boolean[][] isVisited, List<Integer>res) {
        while (col < matrix[0].length && !isVisited[row][col]) {
            res.add(matrix[row][col]);
            isVisited[row][col] = true;
            col++;
        }
        return --col;
    }

    public int down(int row, int col, int[][] matrix, boolean[][] isVisited, List<Integer>res) {
        while (row < matrix.length && !isVisited[row][col]) {
            res.add(matrix[row][col]);
            isVisited[row][col] = true;
            row++;
        }
        return --row;
    }

    public int left(int row, int col, int[][] matrix, boolean[][] isVisited, List<Integer>res) {
        while (col >= 0 && !isVisited[row][col]) {
            res.add(matrix[row][col]);
            isVisited[row][col] = true;
            col--;
        }
        return ++col;
    }

    public int up(int row, int col, int[][] matrix, boolean[][] isVisited, List<Integer>res) {
        while (row >= 0 && !isVisited[row][col]) {
            res.add(matrix[row][col]);
            isVisited[row][col] = true;
            row--;
        }
        return ++row;
    }
}
