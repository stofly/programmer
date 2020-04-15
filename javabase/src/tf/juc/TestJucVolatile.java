package tf.juc;

/**
 * @author stf
 * 内存可见性问题：当多个线程操作共享数据时，彼此不可见。
 * 下面那个线程把flag改成了true,主线程应该读取flag为true跳出死循环，事实上没有停在哪里，也就是说两个线程，一个修改了，另一个没看到
 */
public class TestJucVolatile {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        while (true) {
                if (threadDemo.isFlag()) {
                    System.out.println("主线程读取到的flag = " + threadDemo.isFlag());
                    break;
                }
        }
    }
}

/**
 * 这个线程是用来修改flag的值的
 */
class ThreadDemo implements Runnable {
    /**
     * 加volatile解决内存可见性
     */
    public volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("ThreadDemo线程修改后的flag = " + isFlag());
    }

    /**
     * 获取flag的值
     *
     * @return
     */
    public boolean isFlag() {
        return flag;
    }
}
