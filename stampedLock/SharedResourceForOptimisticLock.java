package stampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceForOptimisticLock {
    boolean isAvailable = false;
    int val = 10;

    public void producer(StampedLock lock)
    {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Taken Optimistic lock " + Thread.currentThread().getName());
            Thread.sleep(4000);

            if(lock.validate(stamp))
            {
                isAvailable = true;
                val = 9;
                System.out.println("Updated sucessfylly"+ val +" "+ Thread.currentThread().getName());
            }
            else {
                System.out.println("Roll Back done"+ val +" "+  Thread.currentThread().getName());
            }
        } catch (Exception e) {

        }

    }
    public void consumer(StampedLock lock)
    {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write Lock acquired by" + Thread.currentThread().getName());
            val = 1;
        } catch (Exception e) {

        }
        finally {
            lock.unlock(stamp);
            System.out.println("Write Lock released by" + Thread.currentThread().getName());

        }
    }

}
