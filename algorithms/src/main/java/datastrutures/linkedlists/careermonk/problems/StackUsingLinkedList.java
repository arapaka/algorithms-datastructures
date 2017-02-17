package datastrutures.linkedlists.careermonk.problems;

import datastrutures.linkedlists.datastructuredefinitions.ListNode;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by archith.rapaka on 2/17/17.
 * Implement staack using linkedlist
 * problem 1
 */
public class StackUsingLinkedList<K extends Object> implements Iterable<K> {
    private ListNode head;
    private int count;

    public StackUsingLinkedList(){
        head = null;
    }
    // push or add elements to stack
    public void push(K k) {
        ListNode first = head;
        head = new ListNode(k);
        head.next = first;
    }

    public K pop() {
        if(head == null){
            throw new UnsupportedOperationException("Stack is empty!");
        }
        K k = (K)head.data;
        head = head.next;
        count--;
        return k;
    }


    public void print() {
        Iterator it = this.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Override
    public Iterator<K> iterator() {
        return new StackIterator();
    }

    @Override
    public void forEach(Consumer<? super K> action) {

    }

    @Override
    public Spliterator<K> spliterator() {
        return null;
    }

    /**
     * Iterator class for above data structure
     */
    private class StackIterator implements Iterator<K> {
        private ListNode current = head;

        public boolean hasNext(){
            return current != null;
        }

        public void remove() {

        }

        public K next() {
            K k = (K) current.data;
            current = current.next;
            return k;
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList sl = new StackUsingLinkedList();

        for (int i = 0; i < 10; i++) {
            sl.push(i);
        }
        sl.print();
    }
}