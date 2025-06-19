package SemaphoreLock;

import stampedLock.SharedResourceForOptimisticLock;
import stampedLock.SharedResourceForStampedLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

public class SemaphoreLockExp {

    public static void main(String[] args) {
        Semaphore lock = new Semaphore(2);
        SharedResourceForSemaphoreLock sharedResourceForSemaphoreLock = new SharedResourceForSemaphoreLock();
        Runnable run1 = () ->
        {
            sharedResourceForSemaphoreLock.producer(lock);
        };

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run1);
        Thread t3 = new Thread(run1);
        Thread t4 = new Thread(run1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
