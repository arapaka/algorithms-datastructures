package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/15/17.
 */
public class SortedListToBalancedBST {
    static Node head = null;

    public static TreeNode convertListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = convertListToBST(start, mid - 1);
        TreeNode root = new TreeNode(head.data);
        head = head.next;
        root.left = left;
        TreeNode right = convertListToBST(mid + 1, end);
        root.right = right;
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(" " + root.data);
            inorder(root.right);
        }
    }

    static class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // get the length of linked list;
    static int getSize(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node tail = new Node(6);
        head.next.next.next.next.next = tail;
        int size = getSize(head);
        TreeNode x = convertListToBST(1, size);
        inorder(x);
    }
}
