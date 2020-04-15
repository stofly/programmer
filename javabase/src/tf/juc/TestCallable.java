package tf.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author stf
 * 现在Callable接口和实现Runable接口的区别就是，Callable带泛型，其call方法有返回值。使用的时候，需要用FutureTask来接收返回值。
 * 而且它也要等到线程执行完调用get方法才会执行，也可以用于闭锁操作
 */
public class TestCallable {
    public static void main(String[] args){
        CallableDemo callableDemo = new CallableDemo();
        //执行callable方式，需要FutureTask实现类的支持，用来接收运算结果
        FutureTask<Integer> result = new FutureTask<>(callableDemo);
        new Thread(result).start();
        //接收线程运算结果
        try {
            //当上面的线程执行完后，才会打印结果。跟闭锁一样。所有futureTask也可以用于闭锁
            Integer sum = result.get();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0;i<=100;i++){
            sum += i;
        }
        return sum;
    }
}
