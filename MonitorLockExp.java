public class MonitorLockExp  {


    //When any thread is executing the below synchronized method , It puts a monitor lock
    //on the object through which that is triggered or invoked
    //It won't release that MONITOR LOCK until it finishes.
    //All other thread which are working on the same object have to wait until that lock the removes
    public synchronized void task1()
    {
        try
        {
            System.out.println("inside the task 1 ");
            Thread.sleep(3000);
            System.out.println("inside the task 1 After Sleep ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //For this method it won't have method level synchronized it go inside
    //after that it has block level synchronzation , so waits until the other thread removes the monitor lock
    public void task2()
    {
        System.out.println("inside the task 2 ");
        synchronized (this)
        {
            System.out.println("Inside the Synchronized block in task 2");
        }
        System.out.println("Outside the task 2 ");

    }

    public void task3()
    {
        System.out.println("inside the task 3 ");
    }
}
