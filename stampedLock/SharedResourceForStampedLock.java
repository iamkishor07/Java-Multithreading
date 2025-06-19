package stampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceForStampedLock {
    boolean isAvailable = false;

    public void producer(StampedLock lock)
    {
        long stamp = lock.readLock();
        try {
            System.out.println("Read Lock acquired by" + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {

        }
        finally {
            lock.unlock(stamp);
            System.out.println("Read Lock Released by" + Thread.currentThread().getName());
        }
    }
    public void consumer(StampedLock lock)
    {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write Lock acquired by" + Thread.currentThread().getName());

        } catch (Exception e) {

        }
        finally {
            lock.unlock(stamp);
            System.out.println("Write Lock released by" + Thread.currentThread().getName());

        }
    }

}
