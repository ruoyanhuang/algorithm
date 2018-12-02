package LeetCode.FaceBook;

import java.util.Comparator;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Timepoint {
    public int time;
    public int status;
    public Timepoint(int t, int s) {
        time = t;
        status = s;
    }
}

class pointComparator implements Comparator<Timepoint> {
    @Override
    public int compare(Timepoint t1, Timepoint t2) {
        return t1.time > t2.time ? 1 : -1;
    }
}

public class minMeetingRooms {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Timepoint> pq = new PriorityQueue<>(new pointComparator());
        for (int i = 0; i < intervals.length; i++) {
            pq.offer(new Timepoint(intervals[i].start, 0));
            pq.offer(new Timepoint(intervals[i].end, 1));
        }
        int cur = 0;
        int globalmax = 0;
        Timepoint curr = pq.peek();
        while (!pq.isEmpty()) {
            Timepoint prev = curr;
            boolean update = false;
            curr = pq.poll();
            if (curr.status == 0) {
                cur++;
                if (cur > globalmax) {
                    globalmax = cur;
                    update = true;
                } else {
                    update = false;
                }
            } else {
                if (curr.time == prev.time && prev.status == 0 && update) {
                    globalmax--;
                }
                cur--;
            }
        }
        return globalmax;
    }
}
