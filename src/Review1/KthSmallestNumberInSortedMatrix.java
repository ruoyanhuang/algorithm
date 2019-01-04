package Review1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
    class point {
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<point> pq = new PriorityQueue<>(new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                return matrix[o1.x][o1.y] < matrix[o2.x][o2.y] ? -1 : 1;
            }
        });
        pq.offer(new point(0,0));
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        point cur = new point(0,0);
        while (k > 0) {
            cur = pq.poll();
            k--;
            if (!isOutOfBound(cur.x + 1, cur.y, matrix.length, matrix[0].length) && !visited[cur.x + 1][cur.y]) {
                visited[cur.x + 1][cur.y] = true;
                pq.offer(new point(cur.x + 1, cur.y));
            }
            if (!isOutOfBound(cur.x, cur.y + 1, matrix.length, matrix[0].length) && !visited[cur.x][cur.y + 1]) {
                visited[cur.x][cur.y + 1] = true;
                pq.offer(new point(cur.x, cur.y + 1));
            }
        }
        return matrix[cur.x][cur.y];
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
