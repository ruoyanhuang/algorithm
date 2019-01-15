package LeetCode.Company.GoldmanSachs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class mergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (Interval i : intervals) {
            int left = i.start;
            int right = i.end;
            if (res.size() == 0 || i.start > res.get(res.size() - 1).end) {
                res.add(new Interval(left, right));
            } else {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, right);
            }
        }
        return res;
    }
}
