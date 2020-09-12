package Base.base2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * “异步”模型，开启一个线程去执行一个任务，并且这个任务执行完成后有一个返回值。
 * Callable与Runnable类似，同样是只有一个抽象方法的函数式接口。不同的是，Callable提供的方法是有返回值的，而且支持泛型。
 *
 * 一般是配合线程池工具ExecutorService来使用
 * 使用submit方法来让一个Callable接口执行。它会返回一个Future，后续的程序可以通过这个Future的get方法得到结果。
 *
 * Future接口的cancel方法是试图取消一个线程的执行，是试图取消，并不一定能取消成功。
 * 有时候，为了让任务有能够取消的功能，就使用Callable来代替Runnable。
 * 如果为了可取消性而使用 Future但又不提供可用的结果，则可以声明 Future<?>形式类型、并返回 null作为底层任务的结果。
 */
public class Demo1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 模拟计算需要一秒
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String args[]) throws Exception {
        // 使用
        ExecutorService executor = Executors.newCachedThreadPool();
        Demo1 task = new Demo1();
        Future<Integer> result = executor.submit(task);
        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(result.get());
    }
}
