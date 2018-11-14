package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomizedSet {
    List<Integer> randomlist;
    HashMap<Integer, Integer> randommap;

    public RandomizedSet() {
        this.randomlist = new ArrayList<>();
        this.randommap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (this.randommap.containsKey(val)) {
            return false;
        } else {
            this.randomlist.add(val);
            this.randommap.put(val, this.randomlist.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!this.randommap.containsKey(val)) {
            return false;
        } else {
            int index = this.randommap.get(val);
            int tmp = this.randomlist.get(this.randomlist.size() - 1);
            this.randommap.put(tmp, index);
            this.randommap.remove(val);
            this.randomlist.set(index, tmp);
            this.randomlist.remove(this.randomlist.size() - 1);

            return true;
        }
    }

    public int getRandom() {
        if (this.randomlist == null || this.randomlist.size() == 0) {
            return -1;
        }
        int size = this.randomlist.size();
        int randomIndex = (int)(Math.random() * (size - 1));
        return this.randomlist.get(randomIndex);
    }
}
