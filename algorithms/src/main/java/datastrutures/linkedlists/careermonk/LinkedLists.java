package datastrutures.linkedlists.careermonk;

import datastrutures.linkedlists.datastructuredefinitions.ListNode;

/**
 * Created by archithrapaka on 2/8/17.
 * This is a singly linked list with basic operations
 */
public class LinkedLists {

    /**
     * Print the contents of linked list
     */
    public void print(ListNode head){
         if(head == null){
             throw new IllegalArgumentException("the list is empty");
         }
        ListNode temp = head;

         while (temp != null){
              System.out.print(temp.data + " ->");
              temp = temp.next;
         }
    }

    /**
     * Inserting an item in the SLL and return it's head
     */

    public ListNode insertBeforeHead(ListNode head , int k){
        // if the head is null , create a new node and make it head

        ListNode newNode = new ListNode(k);
        newNode.next = head;
        head = newNode;
        return head;
    }

    /**
     * Insert at the end of the list
     */

    public ListNode insertAtTheEnd(ListNode head , int k){
         if(head == null){
             return insertBeforeHead(head,k);
         }


         ListNode temp = head;
        // create a new node
         ListNode newNode = new ListNode(k);

         while (temp != null){
             temp = temp.next;
         }

         temp.next = newNode;
         newNode.next = null;
         return head;
    }

    /**
     * Insert at the middle
     */
    public ListNode insertAtMiddle(ListNode head , int position , int k) {
         int counter = 1;

         ListNode newNode = new ListNode(k);

          if(position == 1){
              return insertBeforeHead(head,k);
          }

          ListNode curr = head;

           ListNode prev = null;

          while (curr != null && counter!= position){
                 prev = curr;
                 curr = curr.next;
                 counter++;
          }

        /**
         * now that current node points to the target place and prev is one node behind it
         */
       newNode.next = curr;
        prev.next = newNode;

     return head;
    }

    /**
     * SLL deletion
     */
    public void removeFromHead(ListNode head){
          if(head == null){
              throw new IllegalArgumentException("head is empty");
          }
          ListNode temp = head;
          head = temp.next;
          temp.next = null;

    }
}
