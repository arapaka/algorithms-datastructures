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
    public ListNode insertAtPosition(ListNode head , int position , int k) {

        if(position < 0 ) {
             return insertBeforeHead(head,k);
        }

        if(position >= getLength(head)) {
            return insertAtTheEnd(head,k);
        }
        // insert at the middle

        ListNode curr = head;
        ListNode newNode = new ListNode(k);

        for (int i = 1 ; i < position ; i++) {
             curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
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

    /**
     * remove from a position sll
     *
     */

    public synchronized ListNode  removeFrom(ListNode head , int position){

           if(head == null){
               throw new IllegalArgumentException("head cannot be empty ");
           }

           ListNode temp = head;

        // get the node at the position
        for (int i = 1; i < position; i++) {
               temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    /**
     * remove first matched data
     */

    public synchronized ListNode removeMatched(ListNode head , Integer target) {
            if(head == null){
                throw new IllegalArgumentException("head cannot be empty !");
            }

            // create a fake node
            ListNode fakeHead = new ListNode(0);
            fakeHead.next = head;
            ListNode curr = fakeHead;

            while (curr.next != null){
                     if(curr.next.data == target){
                         curr.next = curr.next.next;
                     }
                     else {
                         curr = curr.next;
                     }
            }
            return fakeHead.next;
    }

    public int getLength(ListNode head){
         if(head == null){
             return 0;
         }
         ListNode temp = head;
        int counter = 1;

        while (temp != null){
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    /**
     * Empty a list
     */
    public void clearList(ListNode head){
         if(head == null){
             return;
         }
         head = null;
    }

    /**
     * Find the position of first matching value in the list
     */
    public int searchByValue(ListNode head , Integer data){
        // head is null
        if(head == null){
               return -1;
           }

        ListNode node = head;
        int counter = 1;

        while (node != null){

                 if(node.data == data){
                      return counter;
                 }
            counter++;
            node = node.next;
        }
        return -1;
    }
}
