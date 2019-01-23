package LeetCode.Company.GoldmanSachs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int totalCourse = 0;
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            count[prerequisites[i][1]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                queue.add(i);
                totalCourse++;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int pre = graph[cur].get(i);
                count[pre]--;
                if (count[pre] == 0) {
                    queue.offer(pre);
                    totalCourse++;
                }
            }
        }
        return totalCourse == numCourses;
    }
}
