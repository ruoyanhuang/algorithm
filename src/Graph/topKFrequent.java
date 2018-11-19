package Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class mapentry {
    public String word;
    public int freq;
    public mapentry(String word, int freq){
        this.word = word;
        this.freq = freq;
    }
}

class freqComparator implements Comparator<mapentry>{
    @Override
    public int compare(mapentry e1, mapentry e2) {
        if (e1.freq < e2.freq) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class topKFrequent {
    public String[] topKFrequent(String[] combo, int k) {
        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<mapentry> pq = new PriorityQueue<>(new freqComparator());
        for (int i = 0; i < combo.length; i++) {
            if (freq.containsKey(combo[i])) {
                freq.put(combo[i], freq.get(combo[i]) + 1);
            } else {
                freq.put(combo[i], 1);
            }
        }
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.offer(new mapentry(entry.getKey(), entry.getValue()));
        }
        String[] res = new String[Math.min(k, pq.size())];
        for (int j = 0; j < res.length; j++) {
            res[j] = pq.poll().word;
        }
        return res;
    }
}
