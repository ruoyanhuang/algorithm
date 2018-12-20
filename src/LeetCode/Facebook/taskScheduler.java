package LeetCode.FaceBook;

import java.util.Arrays;

public class taskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int[] task = new int[26];
        for (char c : tasks) {
            task[c - 'A']++;
        }
        Arrays.sort(task);
        int interval = 0;
        while (task[25] > 0) {
            int i = 0;                              //i: count during a cycle of n
            while (i <= n) {
                if (task[25] == 0) break;
                if (i < 26 && task[25 - i] > 0) {
                    task[25 - i]--;
                }
                interval++;                         //total time always ++
                i++;
            }
            Arrays.sort(task);                      //resort after finish a cycle to see the most of rest
        }
        return interval;
    }
}
