package tf.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author stf
 * 同步锁
 * 比如买火车票，如果不加锁，会出现多个窗口买一张票，最终会出现负票
 * Lock需要通过lock()方法上锁，通过unlock()方法释放锁。为了保证锁能释放，所有unlock方法一般放在finally中去执行。
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket td = new Ticket();
        new Thread(td, "窗口1").start();
        new Thread(td, "窗口2").start();
        new Thread(td, "窗口3").start();
    }
}

/**
 * 传统加锁
 */
//class Ticket implements Runnable {
//    private int ticket = 101;
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (this) {
//                if (ticket > 1) {
//                    try {
//                        Thread.sleep(200);
//                    } catch (Exception e) {
//                    }
//                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + (--ticket));
//                }
//            }
//        }
//    }
//}


/**
 * 加同步锁
 * 直接创建lock对象，然后用lock()方法上锁，最后用unlock()方法释放锁即可
 */
class Ticket implements Runnable {
    /**
     * 创建lock锁
     */
    private Lock lock = new ReentrantLock();
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            lock.lock();//上锁
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + (--ticket));
                }
            }finally {
                lock.unlock();//释放锁
            }

        }
    }
}