package datastrutures.linkedlists.careermonk;

import datastrutures.linkedlists.datastructuredefinitions.DLLNode;

/**
 * Created by archithrapaka on 2/9/17.
 * operations on DLL
 */
public class DoublyLinkedList {

    private int length = 0;
    // Insert at the front before the head

    private DLLNode head;

    public DLLNode insertBeforeHead(int k) {
        DLLNode newNode = new DLLNode(k);
        if (head == null) {
            head = newNode;
            return head;
        }

        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
        length++;
        return head;
    }

    public DLLNode insertAtTheTail(int k) {
        DLLNode newNode = new DLLNode(k);

        if (head == null) {
            head = newNode;
            return head;
        }

        DLLNode curr = head;

        while (curr != null) {
            curr = curr.getNext();
        }

        // curr is the tail

        curr.setNext(newNode);
        newNode.setPrev(curr);
        length++;
        return head;
    }

    // insertHelper at some position
    public DLLNode insertAtPosition(int value, int position) {
        if (position <= 0 || head == null) {
            return insertBeforeHead(value);
        }

        if (position >= length) {
            return insertAtTheTail(value);
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

    public DLLNode deleteFromHead() {
        if (head == null) {
            throw new IllegalArgumentException("head cannot be empty!");
        }

        if (head.getNext() == null) {
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

    public DLLNode deleteFromTail() {
        if (head == null || head.getNext() == null) {
            return deleteFromHead();
        }

        DLLNode temp = head;

        while (temp != null) {
            temp = temp.getNext();
        }

        // temp is the last node , the Tail

        DLLNode prev = temp.getPrev();
        prev.setNext(null);
        temp = null;
        length--;
        return head;
    }

    public DLLNode deleteFromPosition(int position) {
        if (head == null || head.getNext() == null) {
            return deleteFromHead();
        }
        if (position <= 0) {
            return deleteFromHead();
        }
        if (position >= length) {
            return deleteFromTail();
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

    public void printDll() {
        if (head == null) {
            System.out.println("the list is empty");
            return;
        }
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + "->");
            temp = temp.getNext();
        }
    }

    public synchronized DLLNode removeMatched(int k) {
        if (head == null) {
            throw new IllegalArgumentException("head is empty!");
        }

        if (head.getData() == k) {
            head = head.getNext();
            head.setPrev(null);
            return head;
        }

        DLLNode p = head;

        while (p != null) {
            if (p.getData() == k) {
                System.out.println("Removing node : " + p.getData());
                p.getPrev().setNext(p.getNext());
                p.getNext().setPrev(p.getPrev());
            }
            p = p.getNext();
        }
        return p;
    }

    public static void main(String... args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        //DLLNode node = null;

//        for (int i = 0; i < 7; i+d+) {
//            node = new DLLNode(i);
//            DLL.insertBeforeHead(node,i);
//        }
//
//        DLL.printDll(node);
        dll.insertBeforeHead(1);
        dll.insertBeforeHead(2);
        dll.insertBeforeHead(3);
        dll.insertBeforeHead(4);

        dll.printDll();
        System.out.println("######");
        dll.removeMatched(4);
        //DLL.removeMatched(2);

        dll.printDll();
    }
}
