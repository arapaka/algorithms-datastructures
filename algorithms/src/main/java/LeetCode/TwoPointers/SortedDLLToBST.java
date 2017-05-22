package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/15/17.
 */
public class SortedDLLToBST {
        static DLLNode head;

    public static DLLNode convertDLLToBst(int n){
        if(n <= 0) return null;

        DLLNode left = convertDLLToBst(n/2);
        DLLNode root = head;
        root.prev = left;
        head = head.next;
        root.next = convertDLLToBst(n-1-(n/2));
        return root;
    }
    static class DLLNode {
        int data;
        DLLNode next = null;
        DLLNode prev = null;

        public DLLNode(int data) {
            this.data = data;
        }
    }
}
