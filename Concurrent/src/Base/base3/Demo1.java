package Base.base3;

/**
 * Java中用ThreadGroup来表示线程组，我们可以使用线程组对线程进行批量控制。
 * 每个Thread必然存在于一个ThreadGroup中，Thread不能独立于ThreadGroup存在。
 *
 * 执行main()方法线程的名字是main，如果在new Thread时没有显式指定，
 * 那么默认将父线程（当前执行new Thread的线程）线程组设置为自己的线程组。
 *
 * ThreadGroup管理着它下面的Thread，ThreadGroup是一个标准的向下引用的树状结构，
 * 这样设计的原因是防止"上级"线程被"下级"线程引用而无法有效地被GC回收。
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" +
                    Thread.currentThread().getName());
        });

        testThread.start();
        System.out.println("执行main所在线程的线程组名字： " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("执行main方法线程名字：" + Thread.currentThread().getName());
    }
}
