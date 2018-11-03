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

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            length++;
            return;
        }

        // only one node
        if (length == 1) {

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
     * sorted insertHelper has 3 cases
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

        // if head data > new Node data , insertHelper before head and make it new head

        if ((int) head.data >= k) {
            newNode.next = head;
            head = newNode;
            length++;
            return;
        }

        // insertHelper somewhere in the middle
        ListNode temp = head.next;
        while (temp != head) {
            if ((int) temp.data <= k) {
                newNode.next = temp.next;
                temp.next = newNode;
                length++;
                return;
            }
            temp = temp.next;
        }

    }

    public void print() {
        if (head == null) {
            System.out.println("the list is empty");
            return;
        }
        if (length == 1) {
            System.out.println((int) head.data + "--->" + (int) head.data);
            return;
        }
        ListNode curr = head.next;
        System.out.print("" + (int) head.data + "-->");
        while (curr != head) {
            System.out.print((int) curr.data + "-->");
            curr = curr.next;
        }
    }

    //Insert at the front of linked ist

    public void insertAtTheFront(int k) {
        ListNode newNode = new ListNode(k);
        newNode.next = newNode;

        if (head == null) {
            head = newNode;
            length++;
            return;
        }
        // there is only one node , insertHelper at its front
        if (length == 1) {
            newNode.next = head;
            head.next = newNode;
            head = newNode;
            length++;
            return;
        }

        // more than one node , travel to the tail

        ListNode curr = head;

        while (curr.next != head) {
            curr = curr.next;
        }

        // curr is the tail
        newNode.next = head;
        curr.next = newNode;
        head = newNode;
        length++;
        return;
    }

    //deleting the last node in CLL
    public void deleteTail() {
        if (head == null) {
            System.out.print("THE LIST IS EMPTY!");
            return;
        }

        if (length == 1) {
            head = null;
            length = 0;
            return;
        }

        // more than one node , keep track of curr and prev pointers

        ListNode curr = head;
        ListNode next = head.next;

        while (next.next != head) {
            curr = next;
            next = next.next;
        }
        // curr node is the pre tail node , connect it to head
        curr.next = head;
        // dispose off the tail
        System.out.println("disposing off the tail node : " + next.data);
        next = null;
        length--;
        return;
    }

    // delete Head

    public void deleteHead() {
        if (head == null) {
            System.out.println("head is empty!");
        }

        if (length == 1) {
            head = null;
            length = 0;
            return;
        }
        ListNode curr = head;
        ListNode next = head.next;

        while (next.next != head) {
            next = next.next;
        }

        // next is the tail , point to next node of head;
        next.next = curr.next;
        head = curr.next;
        length--;
        return;
    }

    // utility method get last node

    public ListNode getTail() {
        if (head == null) {
            return null;
        }

        if (length == 1) {
            return head;
        }
        ListNode curr = head.next;

        while (curr != head) {
            curr = curr.next;
        }
        return curr;
    }

    public boolean contains(int k) {
        if (head == null) {
            return false;
        }

        if ((int) head.data == k) {
            return true;
        }
        ListNode curr = head;

        while (curr.next != head) {
            if ((int) curr.data == k) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addToTail(16);
        circularLinkedList.addToTail(15);
        circularLinkedList.addToTail(1);
        circularLinkedList.addToTail(4);

        circularLinkedList.insertAtTheFront(25);
        circularLinkedList.insertAtTheFront(45);

//        circularLinkedList.deleteTail();
//        circularLinkedList.deleteTail();
//        circularLinkedList.deleteTail();

        circularLinkedList.deleteHead();
        circularLinkedList.deleteHead();
        circularLinkedList.deleteHead();

        circularLinkedList.print();


    }

}
