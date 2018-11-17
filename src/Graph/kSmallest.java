package Graph;

import java.util.PriorityQueue;

public class kSmallest {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length < k) {
            return new int[]{};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[k];
        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
        }
        for (int j = 0; j < k; j++) {
            res[j] = pq.poll();
        }
        return res;
    }
}
