package SemaphoreLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;

public class SharedResourceForSemaphoreLock
{
    boolean isAvailble =false;

    public void producer(Semaphore lock)
    {

        try {
            lock.acquire();
            System.out.println(" Lock acquired by " + Thread.currentThread().getName());
            isAvailble = true;
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        finally {
            lock.release();
            System.out.println("Released Lock by "+ Thread.currentThread().getName());
        }
    }

}
