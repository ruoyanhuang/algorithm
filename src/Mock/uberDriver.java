//package Mock;
//
//import java.util.*;
//import java.util.List;
//
//public class uberDriver {
//    public static int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
//
//    public List<Rider> pickUpRider(char[][] matrix, int n) {
//        PriorityQueue<Rider> pq = new PriorityQueue<>((Rider p1, Rider p2) -> {
//            if (p1.cost == p2.cost) {
//                return 0;
//            } else {
//                return p1.cost < p2.cost ? -1 : 1;
//            }
//        });
//        Set<Rider> riders = getAllRiderDistance(matrix);
//        Queue<Point> queue = new ArrayDeque<>();
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//        queue.offer(new Point(0,0));
//        int count = n;
//        int level = 0;
//        while (count > 0) {
//            Point cur = queue.poll();
//            level++;
//            for (int i = 0; i < directions.length; i++) {
//                int row = cur.x + directions[i][0];
//                int col = cur.y + directions[i][1];
//                if (!isOutOfBound(row, col, matrix.length, matrix[0].length) && !visited[row][col]) {
//                    queue.offer(new Point(row, col));
//                    visited[row][col] = true;
//                    if (matrix[row][col] == 'R') {
//                        pq.offer(new Rider(row, col, level));
//                        count--;
//                    }
//                }
//            }
//        }
//    }
//
//    class Rider {
//        int x;
//        int y;
//        int cost;
//        Set<Rider> path;
//        Map<Rider, Integer> distanceMap;
//        public Rider (int x, int y, int cost) {
//            this.x = x;
//            this.y = y;
//            this.cost = cost;
//            this.path = new LinkedHashSet<>();
//            this.distanceMap = new HashMap<>();
//        }
//    }
//
//    class Point {
//        int x;
//        int y;
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    private Set<Rider> getAllRiderDistance(char[][] matrix){
//        Set<Rider> riders = new HashSet<>();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 'R') {
//                    Rider rider = new Rider(i, j);
//                    riders.add(rider);
//                    buildDistanceMap(rider, matrix);
//                }
//            }
//        }
//        return riders;
//    }
//
//    private void buildDistanceMap(Rider rider, char[][] matrix) {
//
//    }
//
//    public boolean isOutOfBound(int x, int y, int row, int col) {
//        return x < 0 || x >= row || y < 0 || y >= col;
//    }
//
//}
