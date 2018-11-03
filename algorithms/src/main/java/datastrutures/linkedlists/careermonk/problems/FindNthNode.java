package datastrutures.linkedlists.careermonk.problems;

import datastrutures.linkedlists.careermonk.LinkedList;
import datastrutures.linkedlists.datastructuredefinitions.ListNode;

/**
 * Created by archith.rapaka on 2/17/17.
 * Find nth node from end of linkedlist
 */
public class FindNthNode {

    public static int findNthNode(ListNode head, int k) {
        ListNode curr = head;
        ListNode nthNode = head; // traverse this node k steps

        while (nthNode != null && k >= 1) {
            nthNode = nthNode.next;
            k--;
        }

        while (curr != null && nthNode != null) {
            curr = curr.next;
            nthNode = nthNode.next;
        }
        return (int) curr.data;
        //
    }

    public static void main(String[] args) {
        LinkedList LS = new LinkedList();
        LS.insertBeforeHead(4);
        LS.insertBeforeHead(0);
        LS.insertBeforeHead(7);
        LS.insertBeforeHead(3);
        LS.insertBeforeHead(8);
        LS.insertBeforeHead(2);
        LS.insertBeforeHead(1);

        System.out.print(findNthNode(LS.getHead(), 3));

    }
}
