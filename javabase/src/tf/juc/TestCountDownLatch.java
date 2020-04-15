package tf.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author stf
 * java.util.concurrent包中提供了多种并发容器类来改进同步容器的性能。ContDownLatch是一个同步辅助类.
 * 在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行，这就叫闭锁
 */
public class TestCountDownLatch {
    public static void main(String[] args){
        //有多少个线程这个参数就是几
        final CountDownLatch latch = new CountDownLatch(10);
        System.out.println(latch.getCount());
        LatchDemo ld = new LatchDemo(latch);
        long start = System.currentTimeMillis();
        for (int i = 0;i<10;i++){
            new Thread(ld).start();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为："+(end - start)+"秒");
    }
}
class LatchDemo implements Runnable{
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    /**
     * 执行次数
     */
    public static final int EXECUTE_AMOUNT = 500;
    public LatchDemo(){
    }
    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < EXECUTE_AMOUNT; i++) {
                    //50000以内的偶数
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();//每执行完一个就递减一个
            }
        }
    }
}