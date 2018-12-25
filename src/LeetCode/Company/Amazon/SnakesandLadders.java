//package LeetCode.Company.Amazon;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//
//public class SnakesandLadders {
//    class Point {
//        int x;
//        int y;
//        int val;
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    public int snakesAndLadders(int[][] board) {
//        if (board == null || board.length == 0 || board[0].length == 0) {
//            return -1;
//        } else if (board.length <= 2) {
//            return 1;
//        }
//        int N = board.length;
//        Queue<Point> queue = new ArrayDeque<>();
//        queue.offer(new Point(N, 0));
//        int level = 0;
//        while (!queue.isEmpty()) {
//            Point cur = queue.poll();
//            level++;
//            for (int i = 1; i <= 6; i++) {
//                Point next = path(cur, i, board);
//                if (isOutOfBound(next, board)) {
//                    return level;
//                } else if ((N % 2 == 0 && cur.x == 0 && cur.y == 0) || (N % 2 == 1 && cur.x == 0 && cur.y == N - 1)) {
//                    return level;
//                } else {
//
//                }
//            }
//        }
//    }
//
//    public Point path(Point cur, int step, int[][] board) {
//        int N = board.length;
//        int level;
//        int row;
//        int col;
//        if ((N - cur.x) % 2 == 0) {
//            level = (cur.y + step) / N;
//            if (level == 0) {
//                row = cur.x;
//                col = cur.y + step;
//                Point next = new Point(row, col);
//                if (isOutOfBound(next, board) || board[row][col] == -1) {
//                    return next;
//                } else {
//                    return path(next, board[row][col], board);
//                }
//            } else if (level == 2) {
//                return new Point(cur.x - 2, cur.y);
//            } else {
//                int col = N - (step + cur.y - N);
//                return  new Point(cur.x - 1, col);
//            }
//        } else {
//            level = Math.abs(N - 1 - cur.y - step) / N;
//            if (level == 0) {
//                return new Point(cur.x, cur.y - step);
//            } else if (level == 2) {
//                return new Point(cur.x - 2, cur.y);
//            } else {
//                int col = step - cur.y - 1;
//                return new Point(cur.x, col);
//            }
//        }
//    }
//
//    public boolean isOutOfBound(Point cur, int[][] board) {
//        return cur.x < 0 || cur.x >= board.length || cur.y < 0 || cur.y >board[0].length;
//    }
//}
