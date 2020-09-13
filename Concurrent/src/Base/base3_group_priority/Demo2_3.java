package Base.base3_group_priority;

/**
 * Java提供一个线程调度器来监视和控制处于RUNNABLE状态的线程,线程的调度策略采用抢占式，优先级高的线程比优先级低的线程会有更大的几率优先执行。
 * 先级相同的情况下，按照“先到先得”的原则。
 * 每个Java程序都有一个默认的主线程，就是通过JVM启动的第一个线程main线程。
 * 守护线程（Daemon），守护线程默认的优先级比较低。
 *      某线程是守护线程，那如果所有的非守护线程都结束了，这个守护线程也会自动结束。
 *      所有非守护线程结束时，结束其余的子线程（守护线程）自动关闭，就免去了还要继续关闭子线程的麻烦。
 *      一个线程默认是非守护线程，可以通过Thread类的setDaemon(boolean on)来设置。
 */
public class Demo2_3 {
    // 当线程和线程组的优先级不一致的时候将会怎样呢？
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup,"thread");
        thread.setPriority(9);
        // 某个线程优先级大于线程所在线程组的最大优先级，那么该线程的优先级将会失效，取而代之的是线程组的最大优先级。
        System.out.println("我是线程组的优先级"+threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级"+thread.getPriority());
    }
}
