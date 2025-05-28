package SharedResourceOnThreadsDemo;

public class CosumeTask implements Runnable{

    SharedResource sharedResource;
    public CosumeTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("inside the consumer task : "+ Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
