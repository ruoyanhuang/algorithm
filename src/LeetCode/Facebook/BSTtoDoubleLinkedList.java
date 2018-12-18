package LeetCode.Facebook;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTtoDoubleLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        inOrder(root, queue);
        Node dummy = new Node();
        Node head = dummy;
        head.right = queue.poll();
        head = head.right;
        Node cur = dummy;
        while (!queue.isEmpty()) {
            cur.right = queue.poll();
            cur = cur.right;
            head.right = cur;
            cur.left = head;
            head = cur;
        }
        cur.right = dummy.right;
        dummy.right.left = cur;
        return dummy.right;
    }

    public void inOrder(Node root, Queue<Node> queue) {
        if (root == null) {
            return;
        }
        inOrder(root.left, queue);
        queue.offer(root);
        inOrder(root.right, queue);
    }
}
