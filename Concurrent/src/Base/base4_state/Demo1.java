package Base.base4_state;

import org.junit.Test;

/**
 * NEW状态的线程此时尚未启动。这里的尚未启动指的是还没调用Thread实例的start()方法。
 * RUNNABLE表示当前线程正在运行中。处于RUNNABLE状态的线程在Java虚拟机中运行，也有可能在等待CPU分配资源。
 * BLOCKED阻塞状态。处于BLOCKED状态的线程正等待锁的释放以进入同步区。
 * WAITING等待状态。处于等待状态的线程变成RUNNABLE状态需要其他线程唤醒，以下三个方法可以进入此状态
 *      - Object.wait()：使当前线程处于等待状态直到另一个线程唤醒它；
 *      - Thread.join()：等待线程执行完毕，底层调用的是Object实例的wait方法；
 *      - LockSupport.park()：除非获得调用许可，否则禁用当前线程进行线程调度。
 * TIMED_WAITING超时等待状态。线程等待一个具体的时间，时间到后会被自动唤醒。
 *      - Thread.sleep(long millis)：使当前线程睡眠指定时间；
 *      - Object.wait(long timeout)：线程休眠指定时间，等待期间可以通过notify()/notifyAll()唤醒；
 *      - Thread.join(long millis)：等待当前线程最多执行millis毫秒，如果millis为0，则会一直执行；
 *      - LockSupport.parkNanos(long nanos)： 除非获得调用许可，否则禁用当前线程进行线程调度指定时间；
 *      - LockSupport.parkUntil(long deadline)：同上，也是禁止线程进行调度指定时间；
 * TERMINATED终止状态。此时线程已执行完毕。
 */
public class Demo1 {

    //处于NEW状态的线程此时尚未启动。这里的尚未启动指的是还没调用Thread实例的start()方法。
    @Test
    public void testStateNew() {
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState()); // 输出 NEW
    }

    // BLOCKED与RUNNABLE状态的转换
    @Test
    public void testBlocked() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        a.start();
        Thread.sleep(1000L); // 需要注意这里main线程休眠了1000毫秒，而testMethod()里休眠了2000毫秒
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
        /**
         * a的状态转换过程：RUNNABLE（a.start()） -> TIMED_WATING（Thread.sleep()）->RUNABLE（sleep()时间到）->BLOCKED(未抢到锁，可能状态) -> TERMINATED
         * b的状态转换过程：RUNNABLE（b.start()) -> BLOCKED(未抢到锁，可能状态) ->TERMINATED
         */
    }

    // WAITING状态与RUNNABLE状态的转换
    @Test
    public void testWaiting() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        a.start();
        // 调用join()方法不会释放锁，会一直等待当前线程执行完毕（转换为TERMINATED状态）。
        a.join();
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出 TERMINATED
        System.out.println(b.getName() + ":" + b.getState());
        // b线程的状态，有可能打印RUNNABLE（尚未进入同步方法），也有可能打印TIMED_WAITING（进入了同步方法）
    }

    // TIMED_WAITING与RUNNABLE状态转换
    @Test
    public void testTimedWaiting() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        a.start();
        // join(long)使当前线程执行指定时间，并且使线程进入TIMED_WAITING状态。
        a.join(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出 TIEMD_WAITING
        System.out.println(b.getName() + ":" + b.getState());
        // b线程状态仍然不固定（RUNNABLE或BLOCKED）。
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 线程中断
     * Java里还没有安全直接的方法来停止线程，但提供了线程中断机制
     * 线程中断机制是一种协作机制。需要注意，通过中断操作并不能直接终止一个线程，而是通知需要被中断的线程自行处理。
     *      - Thread.interrupt()：中断线程。这里的中断线程并不会立即停止线程，而是设置线程的中断状态为true（默认是flase）；
     *      - Thread.interrupted()：测试当前线程是否被中断。线程的中断状态受这个方法的影响，意思是调用一次使线程中断状态设置为true，连续调用两次会使得这个线程的中断状态重新转为false；
     *      - Thread.isInterrupted()：测试当前线程是否被中断。与上面方法不同的是调用这个方法并不会影响线程的中断状态。
     * 在线程中断机制里，当其他线程通知需要被中断的线程后，线程中断的状态被设置为true，
     * 但是具体被要求中断的线程要怎么处理，完全由被中断线程自己而定，
     * 可以在合适的实际处理中断请求，也可以完全不处理继续执行下去。
     */
}
