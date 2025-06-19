package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResourceForReadWriteLock {
    boolean isAvailble =false;

    public void producer(ReadWriteLock lock)
    {
        lock.readLock().lock();
        try {

            System.out.println("Read Lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        finally {
            lock.readLock().unlock();
            System.out.println("Released Read Lock by "+ Thread.currentThread().getName());
        }
    }


    public void consumer(ReadWriteLock lock)
    {
        lock.writeLock().lock();
        try
        {
            System.out.println("Write Lock acquired by "+ Thread.currentThread().getName());
            isAvailble = true;
        } catch (Exception e) {

        }finally {
            lock.writeLock().unlock();
            System.out.println("Released Write Lock by " + Thread.currentThread().getName());
        }
    }


}
