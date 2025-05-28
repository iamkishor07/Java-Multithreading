public class MonitorLockMain {
    public static void main(String[] args)
    {


        //We have monitorLockThread that implements Runnable interface &
        // monitorLockExp that contains all the methods that need to execute when thread starts
        MonitorLockExp monitorLockExp = new MonitorLockExp();
        MonitorLockThreadRunnable monitorLockThread = new MonitorLockThreadRunnable(monitorLockExp);

        ///*** ALL THREADS ARE WORKING ON SINGLE INSTANCE / OBJECT

        //we need to pass Runnable object referencce
        Thread thread1 = new Thread(monitorLockThread);

        //Creating other threads with lambda expression
        //will pass which method the run of thread need to invoke,
        //It invokes the run method of the runnable interface that we have passed as constructor parameter
        Thread thread2 = new Thread(() -> monitorLockExp.task2());

        Thread thread3 = new Thread(() -> monitorLockExp.task3());


        thread1.start();
        thread2.start();
        thread3.start();
    }

}
