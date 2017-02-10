package datastrutures.linkedlists.careermonk;

import datastrutures.linkedlists.datastructuredefinitions.DLLNode;

/**
 * Created by archithrapaka on 2/9/17.
 * operations on DLL
 */
public class DoublyLinkedList {

    private int length = 0;
    // Insert at the front before the head

    public DLLNode insertBeforeHead(DLLNode head , int k){
        DLLNode newNode = new DLLNode(k);
          if(head == null){
              head = newNode;
              return head;
          }

        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
        length++;
        return head;
    }

    public DLLNode insertAtTheTail(DLLNode head , int k){
        DLLNode newNode = new DLLNode(k);

          if(head == null){
              head = newNode;
              return head;
          }

        DLLNode curr = head;

          while (curr != null){
               curr = curr.getNext();
        }

        // curr is the tail

        curr.setNext(newNode);
        newNode.setPrev(curr);
        length++;
        return head;
    }

    // insert at some position
    public DLLNode insertAtPosition(DLLNode head,int value , int position){
            if(position <= 0 || head == null) {
                return insertBeforeHead(head,value);
            }

            if(position >= length){
                return insertAtTheTail(head,value);
            }

            DLLNode curr = head;

        for (int i = 1; i < position; i++) {
            curr = curr.getNext();
        }
        DLLNode newNode = new DLLNode(value);

        newNode.setNext(curr.getNext());
        newNode.setPrev(curr);
        curr.getNext().setPrev(newNode);
        curr.setNext(newNode);
        length++;
        return head;
    }

    public DLLNode deleteFromHead(DLLNode head){
        if(head == null){
            throw new IllegalArgumentException("head cannot be empty!");
        }

        if(head.getNext() == null){
            head = null;
            length--;
            return null;
        }

        DLLNode temp = head;
        head = temp.getNext();

        temp.getNext().setPrev(null);
        temp.setNext(null);
        length--;
        return head;
    }

    public DLLNode deleteFromTail(DLLNode head){
        if(head == null || head.getNext() == null){
            return deleteFromHead(head);
        }

        DLLNode temp = head;

        while (temp != null){
             temp = temp.getNext();
        }

        // temp is the last node , the Tail

        DLLNode prev = temp.getPrev();
        prev.setNext(null);
        temp = null;
        length--;
        return head;
    }

    public DLLNode deleteFromPosition(DLLNode head , int position){
         if(head == null || head.getNext() == null){
             return deleteFromHead(head);
         }
          if(position <= 0){
             return deleteFromHead(head);
          }
          if(position >= length){
             return deleteFromTail(head);
          }

          DLLNode temp = head;

        for (int i = 1; i < position; i++) {
             temp = temp.getNext();
        }
        DLLNode prev = temp.getPrev();
        DLLNode next = temp.getNext();

        prev.setNext(next);
        next.setPrev(prev);
        temp.setPrev(null);
        temp.setNext(null);
        temp = null;
        return head;
    }

    public void printDll(DLLNode head){
         if(head == null){
             System.out.println("the list is empty");
             return;
         }
         DLLNode temp = head;
         while (temp != null) {
             System.out.print(temp.getData() + "->");
                     temp = temp.getNext();
         }
    }

    public static void main(String...args){
        DoublyLinkedList DLL = new DoublyLinkedList();
       DLLNode head = new DLLNode(0);
       DLLNode node = DLL.insertBeforeHead(head,1);
       DLLNode node2 = DLL.insertBeforeHead(node,2);
        DLLNode node3 = DLL.insertBeforeHead(node2,3);
        DLLNode node4 = DLL.insertBeforeHead(node3,4);
        DLLNode node5 = DLL.insertBeforeHead(node4,5);
        DLL.printDll(node5);
    }
}
