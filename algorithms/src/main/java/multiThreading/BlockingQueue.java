package multiThreading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
/**
 * Created by archithrapaka on 6/27/17.
 */
public class BlockingQueue {

    private Lock lock = new ReentrantLock();
    private Condition queueCheck;

    private List queue = new LinkedList();
    private int  limit = 10;

    public BlockingQueue(int limit){
        this.limit = limit;
        queueCheck = lock.newCondition();
    }


    public synchronized void enqueue(Object item)
            throws InterruptedException  {
        while(this.queue.size() == this.limit) {
            wait(); // or you can do this queueCheck.await();
        }
        if(this.queue.size() == 0) {
            notifyAll(); // or you can do this queueCheck.signalAll();
        }
        this.queue.add(item);
    }


    public synchronized Object dequeue()
            throws InterruptedException{
        while(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }

        return this.queue.remove(0);
    }

}
