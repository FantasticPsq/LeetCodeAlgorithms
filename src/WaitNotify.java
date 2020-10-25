import jdk.nashorn.internal.runtime.ECMAException;

import java.util.concurrent.CountDownLatch;

public class WaitNotify {
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        final Object o = new Object();
        char[] str1 = "1234567".toCharArray();
        char[] str2 = "ABCDEFG".toCharArray();
        new Thread(() -> {
            synchronized (o) {
                for(char c : str1){
                    System.out.println(c);
                    latch.countDown();
                    try {
                        // 唤醒其他线程
                        o.notify();
                        // 让出锁
                        o.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//必须，否则程序无法停止
            }
        }, "T1").start();
        new Thread(() -> {
            try {
                latch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for(char c:str2) {
                    System.out.println(c);
//                    latch.countDown();
                    try {
                        o.notify();
                        o.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "T2").start();
    }
}
