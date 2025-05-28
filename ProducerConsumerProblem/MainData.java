package ProducerConsumerProblem;


public class MainData {
    public static void main(String[] args)
    {
         SharedResourceBuffer sharedResourceBuffer = new SharedResourceBuffer(3);

         Thread producerData = new Thread(new ProducerData(sharedResourceBuffer)) ;
         Thread cosumerData = new Thread(new ConsumerData(sharedResourceBuffer)) ;

        cosumerData.start();
        producerData.start();
    }
}
