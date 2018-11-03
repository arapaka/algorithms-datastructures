package datastrutures.linkedlists.careermonk;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by archith.rapaka on 2/17/17.
 */
public class SkipList<T extends Comparable<T>, U> {

    private Node head;
    private Random random;
    private long size;
    private double p;


    private long level() {
        long level = 0;
        while (level <= size && random.nextDouble() < p) {
            level++;
        }
        return level;
    }

    /**
     * initialize skip list with default values
     */
    public SkipList() {
        head = new Node(null, null, 0, null, null);
        random = new Random();
        size = 0;
        p = 0.5;
    }

    public void add(T key, U value) {
        long level = level();

        if (level > head.level) {
            head = new Node(null, null, level, null, head);
        }
        Node curr = head;
        Node last = null;

        while (curr != null) {
            if (curr.next == null || curr.next.key.compareTo(key) > 0) {
                if (level >= curr.level) {
                    Node n = new Node(key, value, curr.level, curr.next, null);

                    if (last != null) {
                        last.down = n;
                    }
                    curr.next = n;
                    last = n;
                }
                curr = curr.down;
                continue;

            } else if (curr.next.key.equals(key)) {
                curr.next.value = value;
                return;
            }
            curr = curr.next;
        }
        size++;
    }

    /**
     * contains
     */
    public boolean containsKey(T key) {
        return get(key) != null;
    }

    /**
     * get key method
     */

    public U get(T key) {

        Node curr = head;

        while (curr != null) {
            if (curr.next == null || curr.next.key.compareTo(key) > 0) {
                curr = curr.down;
                continue;
            } else if (curr.next.key.equals(key)) {
                return curr.next.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public U remove(T key) {
        U value = null;
        Node curr = head;

        while (curr != null) {
            if (curr.next == null || curr.next.key.compareTo(key) >= 0) {
                if (curr.next != null && curr.next.key.equals(key)) {
                    value = curr.next.value;
                    curr.next = curr.next.next;
                }
                curr = curr.down;
                continue;
            }
            curr = curr.next;
        }
        size--;
        return value;
    }

    /**
     * Node class for Skip List
     */
    private class Node {
        public T key;
        public U value;
        public long level;
        public Node next;
        public Node down;

        public Node(T key, U value, long level, Node next, Node down) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.down = down;
        }
    }

    public static void main(String[] args) {
        // System.out.print("HELLO");
        SkipList s = new SkipList();

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i <= 10; i++) {
            s.add(i, i);
            // map.put(i,i);
        }

        //long start = System.currentTimeMillis();
        int key = (int) s.get(0);
        //int value = map.get(99999);
        //long end = (System.currentTimeMillis()-start)/1000;

        System.out.println(key);
    }

}
