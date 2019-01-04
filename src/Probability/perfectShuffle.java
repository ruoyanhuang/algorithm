//package Probability;
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class perfectShuffle {
//    public void shuffle(int[] array) {
//        if (array.length <= 1) return;
//        for (int i = array.length; i >= 1; i--) {
//            int random = (int) Math.random() * i;
//            swap(array, random, i - 1);
//        }
//    }
//
//    private void swap(int[] array, int left, int right) {
//        int tmp = array[left];
//        array[left] = array[right];
//        array[right] = tmp;
//    }
//    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder())
//}
