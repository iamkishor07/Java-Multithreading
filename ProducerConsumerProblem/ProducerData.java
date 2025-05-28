package ProducerConsumerProblem;


public class ProducerData implements Runnable{

    SharedResourceBuffer sharedResourceBuffer;
    public ProducerData(SharedResourceBuffer sharedResourceBuffer) {
        this.sharedResourceBuffer = sharedResourceBuffer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 6; i++)
        {
            sharedResourceBuffer.produceData( i);
        }
    }
}
