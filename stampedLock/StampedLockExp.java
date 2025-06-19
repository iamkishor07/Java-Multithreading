package stampedLock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExp {
    public static void main(String[] args) {

        SharedResourceForStampedLock sharedResourceForStampedLock = new SharedResourceForStampedLock();
        SharedResourceForOptimisticLock sharedResourceForOptimisticLock = new SharedResourceForOptimisticLock();
        StampedLock lock = new StampedLock();

        Runnable run1 = () ->
        {
            sharedResourceForOptimisticLock.producer(lock);
        };
        Runnable run2 = () ->
        {
            sharedResourceForOptimisticLock.consumer(lock);
        };

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        t1.start();
        t2.start();

        /*
        Runnable run1 = () ->
        {
            sharedResourceForStampedLock.producer(lock);
        };
        Runnable run2 = () ->
        {
            sharedResourceForStampedLock.consumer(lock);
        };

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run1);
        Thread t3 = new Thread(run2);
        t1.start();
        t2.start();
        t3.start();
        */
    }
}
