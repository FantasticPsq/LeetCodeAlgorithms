import java.security.spec.ECField;
import java.util.HashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    public static void main(String[] args) {
        char[] str1 = "1234567".toCharArray();
        char[] str2 = "ABCDEFG".toCharArray();
        new HashSet<>();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        new Thread(()->{
            try{
                lock.lock();
                for(char c:str1){
                    System.out.println(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            try{
                lock.lock();
                for(char c:str2){
                    System.out.println(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
