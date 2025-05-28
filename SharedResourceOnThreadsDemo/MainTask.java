package SharedResourceOnThreadsDemo;

public class MainTask {

    public static void main(String[] args)
    {
        System.out.println("main method start");
        SharedResource sharedResource = new SharedResource();

        Thread producerTask = new Thread(new ProduceTask(sharedResource));

        Thread consumerTask = new Thread(new CosumeTask(sharedResource));

        producerTask.start();
        consumerTask.start();
        System.out.println("main method end");

    }

}
