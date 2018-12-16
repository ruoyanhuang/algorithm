package Mock;

import java.util.*;

public class busPath {
    class point {
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestRoute(int[][] routes, int start, int end) {
        if (routes == null || routes.length == 0) {
            return 0;
        }
        Map<Integer, List<point>> map = new HashMap<>();
        buildMap(routes, map);
        Queue<point> queue = new ArrayDeque<>();
        int level = 0;
        boolean[] isVisited = new boolean[routes.length];
        for (int i = 0; i < routes[0].length; i++) {
            queue.offer(new point(0, i));
        }
        isVisited[0] = true;
        while (!queue.isEmpty()) {
            point cur = queue.poll();
            level++;
            if (!isVisited[level]) {
                for (int i = 0; i < routes[level].length; i++) {
                    if (routes[level][i] == end) {
                        return level + 1;
                    }
                    queue.offer(new point(level, i));
                }
            }
            if (map.get(routes[cur.x][cur.y]).size() > 1) {
                level++;
                for (point p : map.get(routes[cur.x][cur.y])) {
                    if (p.x != cur.x) {
                        queue.offer(new point(p.x, p.y));
                    }
                }
            }
        }
        return level + 1;
    }

    private void buildMap(int[][] routes, Map<Integer, List<point>> map) {
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (map.get(routes[i][j]) == null) {
                    List<point> l = new ArrayList<>();
                    l.add(new point(i,j));
                    map.put(routes[i][j], l);
                } else {
                    map.get(routes[i][j]).add(new point(i,j));
                }
            }
        }
    }
}
