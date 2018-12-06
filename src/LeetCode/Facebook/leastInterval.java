//package LeetCode.FaceBook;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Queue;
//
//public class leastInterval {
//    public int leastInterval(char[] tasks, int n) {
//        if (tasks == null || tasks.length == 0) {
//            return 0;
//        }
//        Map<Character, Integer> total = new HashMap<>();
//        for (int i = 0; i < tasks.length; i++) {
//            if (total.containsKey(tasks[i])) {
//                total.put(tasks[i], total.get(tasks[i]) + 1);
//            } else {
//                total.put(tasks[i], 1);
//            }
//        }
//
//    }
//
//    public int bfs(Map<Character, Integer> total, int n) {
//        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
//
//    }
//}
