package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by archithrapaka on 6/20/17.
 */
public class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<T>();
    private int limit;

    public BlockingQueue(int limit){
        this.limit = limit;
    }

    public boolean isFull() {
        return checkSize(limit);
    }

    public boolean isEmpty() {
        return checkSize(0);
    }

    private boolean checkSize(int size) {
        return queue.size() == size;
    }

    public synchronized void put(T t) throws InterruptedException {
         while (isFull()) {
             wait();
         }
         queue.add(t);
         notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        T t = queue.remove();
        notifyAll();
        return t;
    }
}
