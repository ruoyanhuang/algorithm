package Array;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class largest {
    public int largest(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x < p2.x) {
                    return -1;
                } else {
                    if (p1.x == p2.x) {
                        return p1.y > p2.y ? -1 : 1;
                    }
                }
                return 1;
            }
        });
        int[] dp = new int[points.length];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].y < points[i - 1].y) {
                dp[i] = 0;
            } else if (points[i].y == points[i - 1].y) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.min(max, dp[i]);
        }
        return max;
    }
}
