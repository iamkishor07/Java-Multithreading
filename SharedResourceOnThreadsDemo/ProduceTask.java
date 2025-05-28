package SharedResourceOnThreadsDemo;

public class ProduceTask implements Runnable{

    SharedResource sharedResource;
    public ProduceTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {

        System.out.println("Inside the producer task: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sharedResource.addItem();
    }
}
