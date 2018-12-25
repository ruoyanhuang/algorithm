package LeetCode.Company.FaceBook;

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
        if (queue.isEmpty()) {
            return null;
        }
        Node dummy = new Node();
        Node head = dummy;
        head.right = queue.poll();
        head = head.right;
        Node cur = dummy;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            head.right = cur;
            cur.left = head;
            head = cur;
            cur = cur.right;
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
