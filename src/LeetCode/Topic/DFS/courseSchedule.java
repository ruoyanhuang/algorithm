package LeetCode.Topic.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int j = 0; j < prerequisites.length; j++) {
            graph[prerequisites[j][0]].add(prerequisites[j][1]);
            degree[prerequisites[j][1]]++;
        }
        for (int k = 0; k < degree.length; k++) {
            if (degree[k] == 0) {
                queue.offer(k);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int l = 0; l < graph[cur].size(); l++) {
                int pre = graph[cur].get(l);
                degree[pre]--;
                if (degree[pre] == 0) {
                    count++;
                    queue.offer(pre);
                }
            }
        }
        if (count == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}
