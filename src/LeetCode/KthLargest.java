package LeetCode;

import java.util.PriorityQueue;

public class KthLargest {
    public PriorityQueue<Integer> klargest;
    public int capacity;
    public int[] nums;

    public KthLargest(int k, int[] nums) {
        this.klargest = new PriorityQueue<>(k);
        this.capacity = k;
        this.nums = nums;

        for (int i = 0; i < this.nums.length; i++) {
            if (i < this.capacity) {
                this.klargest.offer(this.nums[i]);
            } else {
                if (this.nums[i] > this.klargest.peek()) {
                    this.klargest.poll();
                    this.klargest.offer(this.nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if (this.klargest.size() < this.capacity) {
            this.klargest.offer(val);
            return this.klargest.peek();
        } else {
            if (val > this.klargest.peek()) {
                this.klargest.poll();
                this.klargest.offer(val);
            }
            return this.klargest.peek();
        }
    }
}
