//package LeetCode.Company.FaceBook;
//
//import entity.TreeNode;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//
//public class BSTIterator {
//    private Deque<TreeNode> stack;
//    private TreeNode cur;
//
//    public BSTIterator(TreeNode root) {
//        stack = new ArrayDeque<>();
//        cur = root;
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        while (cur != null) {
//            stack.offerLast(cur);
//            cur = cur.left;
//        }
//        TreeNode res = stack.pollLast();
//        cur = res.right;
//        return res.key;
//    }
//}
