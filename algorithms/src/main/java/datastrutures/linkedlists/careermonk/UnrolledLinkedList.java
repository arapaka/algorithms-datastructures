package datastrutures.linkedlists.careermonk;

import datastrutures.linkedlists.datastructuredefinitions.ListNode;

/**
 * Created by archith.rapaka on 2/16/17.
 * UnrolledLinked list
 */
public class UnrolledLinkedList {
    private BlockHead blockHead;
    private int length;


    public void insert(int k) {
        // no block heads initialized

        if (length == 0) {
            CircularLinkedList circularLinkedList = new CircularLinkedList();
            circularLinkedList.insertAtTheFront(k);
            blockHead = new BlockHead(circularLinkedList);
            length++;
            return;
        }

        // is the block head full
        if (blockHead.getCapacity() < 4) {
            CircularLinkedList circularLinkedList = blockHead.getCircularLinkedList();
            circularLinkedList.addToTail(k);
            blockHead.setCapacity(circularLinkedList.getLength());
            length++;
        } else {
            createNewTailBlockHead(k);
        }

        // else it is full then either find or create a new block


    }

    public void print() {
        if (blockHead == null) {
            System.out.println("the list is empty");
        }

        BlockHead curr = blockHead;

        while (curr != null) {
            curr.getCircularLinkedList().print();
            System.out.println();
            curr = curr.next;
        }
    }

    private void createNewTailBlockHead(int k) {

        BlockHead curr = blockHead;

        while (curr != null && curr.next != null) {
            curr = curr.next;
        }

        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insertAtTheFront(k);
        BlockHead newBlock = new BlockHead(circularLinkedList);
        curr.next = newBlock;
        length++;
    }

    public static void main(String[] args) {
        UnrolledLinkedList ull = new UnrolledLinkedList();
        ull.insert(5);
        ull.insert(8);
        ull.insert(10);
        ull.insert(56);
        ull.insert(90);

        ull.print();
    }

    static class BlockHead {
        private CircularLinkedList circularLinkedList;
        private BlockHead next;
        private int capacity;

        private boolean contains;

        public boolean isContains(int k) {
            return circularLinkedList.contains(k);
        }

        public CircularLinkedList getCircularLinkedList() {
            return circularLinkedList;
        }

        public void setCircularLinkedList(CircularLinkedList circularLinkedList) {
            this.circularLinkedList = circularLinkedList;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public BlockHead() {

        }

        public BlockHead(CircularLinkedList circularLinkedList) {
            this.circularLinkedList = circularLinkedList;
        }

        public ListNode getHead() {
            return circularLinkedList.getHead();
        }

        public ListNode getTail() {
            return circularLinkedList.getTail();
        }
    }
}
