package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class shortestBridge {
    public class point{
        public int x;
        public int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return -1;
        }
        boolean[][] isVisited = new boolean[A.length][A[0].length];
        Queue<point> queue = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    queue.offer(new point(i, j));
                    isVisited[i][j] = true;
                    break;
                }
            }
            if (!queue.isEmpty()) {
                break;
            }
        }
        helper(A, queue.peek().x, queue.peek().y, queue, isVisited);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                point cur = queue.poll();
                if (cur.x > 0 && !isVisited[cur.x - 1][cur.y]) {
                    if (A[cur.x - 1][cur.y] == 0) {
                        isVisited[cur.x - 1][cur.y] = true;
                        queue.offer(new point(cur.x - 1, cur.y));
                    }
                    if (A[cur.x - 1][cur.y] == 1) {
                        return step;
                    }
                }
                if (cur.x < A.length - 1 && !isVisited[cur.x + 1][cur.y]) {
                    if (A[cur.x + 1][cur.y] == 0) {
                        isVisited[cur.x + 1][cur.y] = true;
                        queue.offer(new point(cur.x + 1, cur.y));
                    }
                    if (A[cur.x + 1][cur.y] == 1) {
                        return step;
                    }
                }
                if (cur.y > 0 && !isVisited[cur.x][cur.y - 1]) {
                    if (A[cur.x][cur.y - 1] == 0) {
                        isVisited[cur.x][cur.y - 1] = true;
                        queue.offer(new point(cur.x, cur.y - 1));
                    }
                    if (A[cur.x][cur.y - 1] == 1) {
                        return step;
                    }
                }
                if (cur.y < A[0].length - 1 && !isVisited[cur.x][cur.y + 1]) {
                    if (A[cur.x][cur.y + 1] == 0) {
                        isVisited[cur.x][cur.y + 1] = true;
                        queue.offer(new point(cur.x, cur.y + 1));
                    }
                    if (A[cur.x][cur.y + 1] == 1) {
                        return step;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public void helper(int[][] A, int x, int y, Queue<point> queue, boolean[][]isVisited) {
        if (x > 0 && !isVisited[x - 1][y] && A[x - 1][y] == 1) {
            isVisited[x - 1][y] = true;
            queue.offer(new point(x - 1, y));
            helper(A, x - 1, y, queue, isVisited);
        }
        if (x < A.length - 1 && !isVisited[x + 1][y] && A[x + 1][y] == 1) {
            isVisited[x + 1][y] = true;
            queue.offer(new point(x + 1, y));
            helper(A, x + 1, y, queue, isVisited);
        }
        if (y > 0 && !isVisited[x][y - 1] && A[x][y - 1] == 1) {
            isVisited[x][y - 1] = true;
            queue.offer(new point(x, y - 1));
            helper(A, x, y - 1, queue, isVisited);
        }
        if (y < A[0].length - 1 && !isVisited[x][y + 1] && A[x][y + 1] == 1) {
            isVisited[x][y + 1] = true;
            queue.offer(new point(x, y + 1));
            helper(A, x, y + 1, queue, isVisited);
        }
    }
}
