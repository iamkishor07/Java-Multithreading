package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExp {
    public static void main(String[] args) {


        //Same lock for different objects.
        ReentrantLock  lock = new ReentrantLock();

        SharedResourceReentrantLock sharedResourceReentrantLock1 = new SharedResourceReentrantLock();

        Thread th1 = new Thread(
                () ->{ sharedResourceReentrantLock1.producer(lock);}
        );
        SharedResourceReentrantLock sharedResourceReentrantLock2 = new SharedResourceReentrantLock();

        Thread th2 = new Thread(
                () ->{ sharedResourceReentrantLock2.producer(lock);}
        );
        Thread th3 = new Thread(
                () ->{ sharedResourceReentrantLock2.producer(lock);}
        );

        th1.start();
        th2.start();
        th3.start();
    }
}
