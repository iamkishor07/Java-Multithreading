package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceReentrantLock {

    private static int cnt = 0;

    public void producer(ReentrantLock lock)
    {
        lock.lock();
        try {

            System.out.println("Lock Accquired By : " + Thread.currentThread().getName() +" - " + cnt);
            cnt++;
            Thread.sleep(4000);
        } catch (Exception e) {

        }
        finally {
            lock.unlock();
            System.out.println("Lock Released By : " + Thread.currentThread().getName() +" - " + cnt);
            cnt++;
        }
    }

}
