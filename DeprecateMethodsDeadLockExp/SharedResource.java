package DeprecateMethodsDeadLockExp;

public class SharedResource {

    boolean isAvailable = false;

    public  synchronized  void produce()
    {
        isAvailable = true;
        System.out.println("Accquired Lock :" + Thread.currentThread().getName());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            //
        }
        System.out.println("Lock Release" + Thread.currentThread().getName());
    }

}
