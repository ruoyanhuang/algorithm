package Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

class point {
    public int row;
    public int col;
    public int value;
    public point(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}

class pointComparator implements Comparator<point> {
    @Override
    public int compare(point p1, point p2) {
        return p1.value < p2.value ? 1 : -1;
    }
}

public class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k > matrix.length * matrix[0].length) {
            return -1;
        }
        PriorityQueue<point> pq = new PriorityQueue<>(new pointComparator());
        pq.offer(new point(0, 0, matrix[0][0]));
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        point cur = new point(0, 0, 0);
        for (int i = 0; i < k; i++) {
            cur = pq.poll();
            int row = cur.row;
            int col = cur.col;
            if (row < matrix.length - 1) {
                if (!isVisited[row + 1][col]) {
                    pq.offer(new point(row + 1, col, matrix[row + 1][col]));
                    isVisited[row + 1][col] = true;
                }
            }
            if (col < matrix[0].length - 1) {
                if (!isVisited[row][col + 1]) {
                    pq.offer(new point(row, col + 1, matrix[row][col + 1]));
                    isVisited[row][col + 1] = true;
                }
            }
        }
        return cur.value;
    }
}
