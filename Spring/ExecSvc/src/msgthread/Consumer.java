package msgthread;
 
import java.util.Vector;
 
public class Consumer extends Thread {
    private int m_id;
    private Producer m_producer;
 
    Consumer(int p_id, Producer p_p) {
        m_id = p_id;
        m_producer = p_p;
    }
 
    @Override
    public void run() {
        try {
            while (true) {
                String message = m_producer.getMessage();
                System.out.println("Consumer : " + m_id + " Got message : " + message);
                if (message.startsWith("sleep")) {
                    System.out.println("Consumer : " + m_id + " Got message : " + message + " Sleeping 5 seconds");
                    sleep(5000);
                }
                else {
                    System.out.println("Consumer : " + m_id + " Got message : " + message + " Generating next prime number");
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
