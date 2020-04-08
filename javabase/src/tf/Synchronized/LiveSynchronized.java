package tf.Synchronized;

//实例锁
public class LiveSynchronized {


    //获取锁
    private Object lock = new Object();

    //锁非静态变量
    public void lockObjectField() throws InterruptedException {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10 * 1000);
        }
    }

    //锁当前对像--this就是当前对象实例
    public void lockThis() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10 * 1000);
        }
    }

    //锁非静态方法
    public void methodLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10 * 1000);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread worker = new Thread(new ObjectLockWorker());
            Thread worker2 = new Thread(new ObjectLockWorker());
            worker.setName("小石头1号-" + i);
            worker2.setName("小石头2号-"+i);
            worker.start();
            worker2.start();
        }
    }

    public static class ObjectLockWorker implements Runnable {
        @Override
        public void run() {
            try {

                LiveSynchronized objectLock = new LiveSynchronized();
                // 方式 1
//                 objectLock.lockObjectField();
                // 方式 2
//                 objectLock.lockThis();
                // 方式 3
                 objectLock.methodLock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
