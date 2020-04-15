package tf.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author stf
 * 解决原子性问题，即产生重复数据，多线程安全问题，比如我们写一个i++的方法，然后开启10个线程去访问它，得到结果应该时一个一个加1，一直到10，
 * 但是实际上就会出现重复值。
 */
public class TestJucAcs {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int x = 0; x < 10; x++) {
            new Thread(atomicDemo).start();
        }
    }
}

/**
 * CAS算法：
 * CAS算法是计算机硬件对并发操作共享数据的支持，CAS包含3个操作数：
 *
 * 内存值V
 * 预估值A
 * 更新值B
 *
 * CAS是一种无锁算法，CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做
 */

class AtomicDemo implements Runnable {
//    private int i = 0;

    AtomicInteger i = new AtomicInteger();
    public int getI(){
        return i.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            //先睡一会
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输出每个线程拿到的I
        System.out.println(getI() + "DingDong");
    }
}
