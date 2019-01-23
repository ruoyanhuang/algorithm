package LeetCode.Company.GoldmanSachs;

public class designHashMap {
    class ListNode{
        int key;
        int val;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    ListNode[] bucket;

    public designHashMap() {
        this.bucket = new ListNode[10000];
    }

    public void put(int key, int value) {
        int index = findIndex(key);
        ListNode head = bucket[index];
        if (head == null) {
            bucket[index] = new ListNode(-1, -1);
        }
        ListNode prev = findPosition(key, head);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = findIndex(key);
        ListNode head = bucket[index];
        if (head == null) {
            return -1;
        }
        ListNode prev = findPosition(key, head);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.val;
        }
    }

    public void remove(int key) {
        int index = findIndex(key);
        ListNode head = bucket[index];
        if (head == null) {
            return;
        }
        ListNode prev = findPosition(key, head);
        if (prev.next == null) {
            return;
        } else {
            ListNode next = prev.next.next;
            prev.next.next = null;
            prev.next = next;
            return;
        }
    }

    private int findIndex(int key) {
        return Integer.hashCode(key) % bucket.length;
    }

    private ListNode findPosition(int key, ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (head != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}
