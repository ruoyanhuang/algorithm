//package LeetCode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class killProcess {
//    class Node {
//        int key;
//        List<Node> children;
//        Node (int key) {
//            this.key = key;
//            this.children = new ArrayList<Node>();
//        }
//    }
//
//    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
//        HashMap<Integer, Node> childs = new HashMap<>();
//        for (int i = 0; i < pid.size(); i++) {
//            Node curr = childs.get(pid.get(i));
//            Node parent = childs.get(ppid.get(i));
//            if (curr == null) {
//                curr = new Node(pid.get(i));
//                childs.put(pid.get(i), curr);
//            }
//            if (parent == null) {
//                parent = new Node(ppid.get(i));
//                childs.put(ppid.get(i), parent);
//            }
//            parent.children.add(curr);
//        }
//        Node target = childs.get(kill);
//        List<Integer> result = new ArrayList<>();
//        return dfs(target, result);
//    }
//
//    public List<Integer> dfs(Node root, List res) {
//        if (root == null) {
//            return null;
//        }
//        res.add(root.key);
//        for (Node n : root.children) {
//            dfs(n, res);
//        }
//        return res;
//    }
//}
