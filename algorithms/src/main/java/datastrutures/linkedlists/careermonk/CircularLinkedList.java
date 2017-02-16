package datastrutures.linkedlists.careermonk;

import datastrutures.linkedlists.datastructuredefinitions.ListNode;

/**
 * Created by archithrapaka on 2/10/17.
 */
public class CircularLinkedList {
    private ListNode head;
    private int length;

    public CircularLinkedList() {
       head = null;
       length = 0;
   }

   public int getCount() {
        if (head == null) {
            return 0;
        }
        ListNode temp = head.next;
        while (temp != head) {
             temp = temp.next;
             length++;
        }
        return length;
   }

   public void addToTail(int k) {
       ListNode newNode = new ListNode(k);

       if(head == null) {
           newNode.next = newNode;
           head = newNode;
            length++;
            return;
          }

          // only one node
          if(length == 1 ){

             newNode.next = head;
              head.next = newNode;
             length++;
             return;
          }

          ListNode curr = head;


        while (curr.next != head) {
              curr = curr.next;
        }

        // curr is the tail
       newNode.next = head;
       curr.next = newNode;
       length++;
   }
    /***
     * sorted insert has 3 cases
     * Before head , in the middle , at the end
     */
    public synchronized void sortedInsert(int k) {
         ListNode newNode = new ListNode(k);

          if (head == null) {
              head = newNode;
              newNode.next = newNode;
              length++;
              return;
          }

          // if head data > new Node data , insert before head and make it new head

          if ((int)head.data >= k) {
             newNode.next = head;
             head = newNode;
             length++;
             return;
          }

          // insert somewhere in the middle
          ListNode temp = head.next;
          while (temp != head) {
                if ((int)temp.data <= k) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                    length++;
                    return;
                }
                temp = temp.next;
          }

    }

    public void print(){
        if(head == null) {
            System.out.println("the list is empty");
            return;
        }
        if(length == 1){
            System.out.println((int)head.data + "--->" + (int)head.data);
            return;
        }
        ListNode curr = head.next;
        System.out.print(""+ (int)head.data +"-->");
        while (curr != head){
            System.out.print((int)curr.data + "-->");
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addToTail(16);
        circularLinkedList.addToTail(15);
        circularLinkedList.addToTail(1);
       circularLinkedList.addToTail(4);
        circularLinkedList.print();

    }

}
