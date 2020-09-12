package Base.base2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Future接口有一个实现类叫FutureTask，FutureTask是实现的RunnableFuture接口的，
 * 而RunnableFuture接口同时继承了Runnable接口和Future接口
 * FutureTask能够在高并发环境下确保任务只执行一次。
 */
public class Demo2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 模拟计算需要一秒
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws Exception {
        // 使用
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new Demo2());
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
