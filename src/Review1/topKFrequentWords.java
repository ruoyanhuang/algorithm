package Review1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < combo.length; i++) {
            if (!map.containsKey(combo[i])) {
                map.put(combo[i], 1);
            } else {
                map.put(combo[i], map.get(combo[i]) + 1);
            }
        }
        String[] res = new String[Math.min(k, map.size())];
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
