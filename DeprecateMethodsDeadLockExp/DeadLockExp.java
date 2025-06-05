package DeprecateMethodsDeadLockExp;

public class DeadLockExp {
    public static void main(String[] args)
    {

        SharedResource sharedResource = new SharedResource();

        System.out.println("Main Method started");

        Thread th1 = new Thread(() ->{
            System.out.println("Thread 1 calling produce Method : " + Thread.currentThread().getName());
            sharedResource.produce();
        });

        Thread th2 = new Thread(()->
        {
            try{
                Thread.sleep(1000);

            } catch (Exception e) {
                //
            }
            System.out.println("Thread 2 calling produce method" + Thread.currentThread().getName());
            sharedResource.produce();
        });

        th1.start();
        th2.start();

        try {
            Thread.sleep(2000);
        }catch (Exception e)
        {

        }
        System.out.println("thread 1 is suspened");
        th1.suspend();
//        try {
//            Thread.sleep(3000);
//        }catch (Exception e)
//        {
//
//        }
//        th1.resume();

    }

}
