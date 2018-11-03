package datastrutures.linkedlists.tutorialhorizon;

import datastrutures.linkedlists.careermonk.LinkedList;
import datastrutures.linkedlists.datastructuredefinitions.ListNode;

/**
 * Created by archithrapaka on 2/16/17.
 *
 * @link
 */
public class MergeLinkedLists {
    public static void mergeAlternatively(ListNode ls, ListNode ls2) {
        if (ls == null && ls2 == null) {
            System.out.println("empty");
            return;
        }

        if (ls == null) {
            ListNode curr = ls2;
            display(curr);
            return;
        }
        if (ls2 == null) {
            ListNode curr = ls;
            display(curr);
            return;
        }

        // merge if both are non null

        ListNode first = ls;
        ListNode second = ls2;

        // to print the merged node later
        ListNode temp = first;

        while (first != null && second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }

        display(temp);
        System.out.println("remaining list");
        display(second);
    }

    public static void display(ListNode head) {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print("->" + currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.insertBeforeHead(5);
        ls.insertAtTheEnd(10);
        ls.insertAtTheEnd(15);
        ls.insertAtTheEnd(20);
        ls.insertAtTheEnd(25);
        //ls.print();

        LinkedList ls2 = new LinkedList();
        for (int i = 3; i <= 21; i = i + 3) {
            ls2.insertAtTheEnd(i);
        }
        //ls2.print();
        mergeAlternatively(ls.getHead(), ls2.getHead());
    }
}
