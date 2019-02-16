package LeetCode.Company.Amazon;

import java.util.*;

public class knearest {
    class point {
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> kClosest(List<List<Integer>> input, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (input == null || input.size() == 0) {
            return res;
        }
        PriorityQueue<point> pq = new PriorityQueue<>(new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                if (o1.x * o1.x + o1.y * o1.y < o2.x * o2.x + o2.y * o2.y) {
                    return -1;
                } else if (o1.x * o1.x + o1.y * o1.y == o2.x * o2.x + o2.y * o2.y) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < input.size(); i++) {
            pq.offer(new point(input.get(i).get(0), input.get(i).get(1)));
        }
        for (int i = 0; i < k; i++) {
            List<Integer> tmp = new ArrayList<>();
            point cur = pq.poll();
            tmp.add(cur.x);
            tmp.add(cur.y);
            res.add(tmp);
        }
        return res;
    }
}
