package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;

    public MedianFinder() {
        this.maxheap = new PriorityQueue<>(Collections.reverseOrder());
        this.minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minheap == null || minheap.size() == 0) {
            minheap.offer(num);
        } else if (num >= minheap.peek()) {
            minheap.offer(num);
        } else {
            maxheap.offer(num);
        }

        if (maxheap.size() > minheap.size()) {
            minheap.offer(maxheap.poll());
        } else if (minheap.size() - maxheap.size() > 1) {
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        } else {
            return minheap.peek();
        }
    }
}
