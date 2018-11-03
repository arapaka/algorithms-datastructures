package codefights;

/**
 * Created by archithrapaka on 5/29/17.
 */
public class IsListPalindrome {

    // listnode
    class ListNode<T> {
        T val;
        ListNode<T> next;

        ListNode(T x) {
            val = x;
        }
    }

    boolean isSameList(ListNode x, ListNode y) {

        while (x != null && y != null) {
            if (!x.val.equals(y.val)) {
                return false;
            }
            x = x.next;
            y = y.next;
        }
        return true;
    }

    boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;

        // reverse the first half while finding the mid point

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = pre;
            pre = slow;
            slow = slow.next;
            pre.next = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }

        return isSameList(pre, slow);
    }
}
