import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class QueueOfTransfer {
    public static void main(String[] args) {
        char[] str1 = "1234567".toCharArray();
        char[] str2 = "ABCDEFG".toCharArray();
        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        BlockingQueue<Character> blockingQueue = new LinkedBlockingDeque<>();
        new Thread(()->{
            for(char c:str1){
                try {
                    queue.transfer(c);
                    System.out.println(queue.take());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (char c:str2){
                try{
                    System.out.println(queue.take());
                    queue.transfer(c);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
