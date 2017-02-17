package datastrutures.linkedlists.careermonk.problems;

import datastrutures.linkedlists.careermonk.LinkedList;
import datastrutures.linkedlists.datastructuredefinitions.ListNode;

/**
 * Created by archith.rapaka on 2/17/17.
 * Find nth node from end of linkedlist
 */
public class FindNthNode {

    public static int findNthNode(ListNode head, int k){
        ListNode curr = head;
        ListNode nthNode = head; // traverse this node k steps

        while (nthNode != null && k >=1) {
            nthNode = nthNode.next;
            k--;
        }

        while (curr != null && nthNode != null){
            curr = curr.next;
            nthNode = nthNode.next;
        }
        return (int)curr.data;
        //
    }

    public static void main(String[] args) {
        LinkedList LS = new LinkedList();
        LS.insertBeforeHead(5);
        LS.insertBeforeHead(15);
        LS.insertBeforeHead(25);
        LS.insertBeforeHead(35);

        System.out.print(findNthNode(LS.getHead(),3));

    }
}
