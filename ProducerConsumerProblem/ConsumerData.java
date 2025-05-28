package ProducerConsumerProblem;

public class ConsumerData implements Runnable{
    SharedResourceBuffer sharedResourceBuffer;
    public ConsumerData(SharedResourceBuffer sharedResourceBuffer) {
        this.sharedResourceBuffer = sharedResourceBuffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i< 6;i++)
            {
                sharedResourceBuffer.consumeData();
            }
        }catch (Exception e)
        {
            //something
        }
    }
}
