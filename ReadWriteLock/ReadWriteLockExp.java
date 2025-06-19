package ReadWriteLock;


import ReentrantLock.SharedResourceReentrantLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExp {
    public static void main(String[] args) {

        SharedResourceForReadWriteLock sharedResourceForReadWriteLock = new SharedResourceForReadWriteLock();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Runnable run1 = ()->
        {
            sharedResourceForReadWriteLock.producer( lock);
        };
        Runnable run2 = ()->
        {
            sharedResourceForReadWriteLock.consumer(lock);
        };

        Thread t1 =new Thread(run1);
        Thread t2 =new Thread(run1);
        Thread t3 =new Thread(run2);
        t1.start();
        t2.start();
        t3.start();


    }
}
